package com.ezgroceries.shoppinglist.Repositories;

import lombok.Data;
import javax.persistence.*;
import java.util.*;

/* to interact with the database scheme */
@Data
@Entity
@Table(name = "shopping_list")
public class ShoppingListEntity {
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    @JoinTable(name = "COCKTAIL_SHOPPING_LIST", joinColumns = @JoinColumn(name = "shoppinglistid"),inverseJoinColumns = @JoinColumn(name = "cocktailid"))
    private List<CocktailEntity> cocktails;

    @Column(name="shoppinglistid", nullable = false)
    @Id
    @GeneratedValue
    private UUID shoppinglistid;

    @Column(name = "name")
    private String name ;
}

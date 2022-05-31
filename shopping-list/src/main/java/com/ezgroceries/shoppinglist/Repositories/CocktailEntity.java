package com.ezgroceries.shoppinglist.Repositories;

import com.ezgroceries.shoppinglist.Utilities.StringSetConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

/* to interact with the database scheme */

@Data
@Entity
@Table(name = "cocktail")
public class CocktailEntity {
    @Column(name="cocktailid", nullable = false)
    @Id
    @GeneratedValue
    private UUID cocktailId;

    @Column(name = "id_drink")
    private String id_drink ;

    @Column(name = "name")
    private String name ;

    @Column(name = "glass")
    private String glass ;

    @Column(name = "instructions")
    private String instructions ;

    @Column(name = "image")
    private String image ;

    @Column(name = "ingredients")
    @Convert(converter = StringSetConverter.class)
    private Set<String> ingredients ;
}

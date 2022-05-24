package com.ezgroceries.shoppinglist.Controllers.ResourceCocktail;

import java.util.UUID;

public class CocktailId {

    /* to have lab02 working(ShoppingController)
    private UUID cocktailId;
    public CocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }
    public UUID getCocktailId() {
        return cocktailId;
    }
    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    } */

    // to have lab04 working
    private String cocktailId;

    // No args constructor
    public CocktailId() {
    }

    // All args constructor
    public CocktailId(String cocktailId) {

        this.cocktailId = cocktailId;

    }

    public String getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(String cocktailId) {
        this.cocktailId = cocktailId;
    }
}

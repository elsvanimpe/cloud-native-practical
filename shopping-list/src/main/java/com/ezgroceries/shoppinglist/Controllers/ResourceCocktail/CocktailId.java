package com.ezgroceries.shoppinglist.Controllers.ResourceCocktail;

import java.util.UUID;

public class CocktailId {

    private UUID cocktailId;

    public CocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

}

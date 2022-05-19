package com.ezgroceries.shoppinglist.Controllers.Resource;

import com.ezgroceries.shoppinglist.Controllers.Resource.CocktailId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingListResource {

    private UUID shoppingListId;
    private String name;
    private List<CocktailId> cocktails = new ArrayList<>();

    public ShoppingListResource(){

    }
    public ShoppingListResource(UUID shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
    }
    public ShoppingListResource(UUID shoppingListId, String name, List<CocktailId> cocktails) {
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.cocktails = cocktails;
    }


    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CocktailId> getCocktails() {
        return cocktails;
    }

    public void setCocktails(List<CocktailId> cocktails) {
        this.cocktails = cocktails;
    }
}















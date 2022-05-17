package com.ezgroceries.shoppinglist;

import java.util.List;
import java.util.UUID;

public class ShoppingListOut {

    private UUID shoppingListId;
    private String name;

    List<String> shoppingListIngredient;


    public ShoppingListOut(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public ShoppingListOut() {
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

    public List<String> getShoppingListIngredientList() {
        return shoppingListIngredient;
    }

    public void setShoppingListIngredientList(List<String> shoppingListIngredient) {
        this.shoppingListIngredient = shoppingListIngredient;
    }
}

package com.ezgroceries.shoppinglist;

import java.util.*;

public class ShoppingListResource {
    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    private UUID shoppingListId;

    public String getShoppingListName() {
        return shoppingListName;
    }

    public void setShoppingListName(String shoppingListName) {
        this.shoppingListName = shoppingListName;
    }

    private String shoppingListName;

    /* No args constructor */
    public ShoppingListResource() {

    }

    /* All args constructor */
    public ShoppingListResource(UUID shoppingListId, String shoppingListName) {

        this.shoppingListId = shoppingListId;
        this.shoppingListName = shoppingListName;

    }
}

















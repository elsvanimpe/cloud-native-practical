package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.Repositories.ShoppingListEntity;

public interface ShoppingListService {
    ShoppingListEntity saveShoppingList(ShoppingListEntity shoppingList);
}

package com.ezgroceries.shoppinglist.Services;


import com.ezgroceries.shoppinglist.Repositories.CocktailEntity;
import com.ezgroceries.shoppinglist.Repositories.ShoppingListEntity;
import com.ezgroceries.shoppinglist.Repositories.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Override
    public ShoppingListEntity addShoppingList(ShoppingListEntity shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingListEntity readShoppingList(UUID uuid) {
        return shoppingListRepository.getById(uuid);
    }


    public ShoppingListEntity setCocktails(UUID uuid, List<CocktailEntity> cocktailIds) {
        ShoppingListEntity shoppingList = readShoppingList(uuid);
        System.out.println(cocktailIds);
        shoppingList.setCocktails(cocktailIds);
        shoppingListRepository.save(shoppingList);
        return (shoppingList);

    }

}

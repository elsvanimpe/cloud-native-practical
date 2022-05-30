package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.Repositories.CocktailEntity;

import java.util.List;

public interface CocktailService {
    // write cocktail in cocktailtable
    CocktailEntity saveCocktailEntity(CocktailEntity cocktailEntity);

    // read a cocktail in  cocktailtable
    List<CocktailEntity> readCocktails (String name);
}

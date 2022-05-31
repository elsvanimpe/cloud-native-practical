package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.Repositories.CocktailEntity;

import java.util.List;

public interface CocktailService {
    // add cocktail in cocktailtable
    CocktailEntity addCocktail(CocktailEntity cocktailEntity);

    // read a cocktail in  cocktailtable
    List<CocktailEntity> readCocktail (String name);
}

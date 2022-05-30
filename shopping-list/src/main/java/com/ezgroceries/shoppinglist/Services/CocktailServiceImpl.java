package com.ezgroceries.shoppinglist.Services;

import com.ezgroceries.shoppinglist.Repositories.CocktailEntity;
import com.ezgroceries.shoppinglist.Repositories.CocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CocktailServiceImpl implements CocktailService {
    @Autowired
    private CocktailRepository cocktailRepository;
    @Override
    //write
    public CocktailEntity saveCocktailEntity(CocktailEntity cocktailEntity)
    {
        return CocktailRepository.save(cocktailEntity);
    }
    //read

}

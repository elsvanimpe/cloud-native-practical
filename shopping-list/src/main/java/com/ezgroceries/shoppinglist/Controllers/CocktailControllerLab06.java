package com.ezgroceries.shoppinglist.Controllers;

import com.ezgroceries.shoppinglist.Controllers.ResourceCocktail.CocktailResource;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListResource;
import com.ezgroceries.shoppinglist.Repositories.CocktailEntity;
import com.ezgroceries.shoppinglist.Services.CocktailService;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CocktailControllerLab06 {

        Map<UUID, ShoppingListResource> shoppinglists = new HashMap<UUID,ShoppingListResource>();

        @Autowired
        private CocktailService cocktailService;

        @GetMapping(value = "/cocktails6", produces = "application/json")
        public ResponseEntity<List<CocktailEntity>> get(@RequestParam String search) {
            return ResponseEntity.ok((cocktailService.readCocktail(search.toString())));
        }

        /* part 2 create cocktails */
        @PostMapping(value = "/addcocktails", consumes = "application/json", produces = "application/json")
        public ResponseEntity <List<CocktailEntity>> create(@RequestBody List<CocktailResource> cocktailResources) throws JsonParseException {
            List<CocktailEntity> cocktailEntityList = new ArrayList<>();
            CocktailEntity cocktailEntity = new CocktailEntity();
            for (CocktailResource cocktailResource2 : cocktailResources) {
                cocktailResource2.setCocktailId(UUID.randomUUID().toString());
                cocktailEntity.setCocktailId(UUID.randomUUID());
                cocktailEntity.setName(cocktailResource2.getName());
                cocktailEntity.setIngredients(new HashSet<>(cocktailResource2.getIngredients()));
                cocktailEntityList.add(cocktailService.addCocktail(cocktailEntity));
            }
            return new ResponseEntity<>(cocktailEntityList, HttpStatus.CREATED);
        }

    }


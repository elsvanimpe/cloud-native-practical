package com.ezgroceries.shoppinglist.Controllers;


import com.ezgroceries.shoppinglist.Controllers.ResourceCocktail.CocktailId;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListOut;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListResource;
import com.ezgroceries.shoppinglist.Databases.CocktailDBClient;
import com.ezgroceries.shoppinglist.Repositories.CocktailEntity;
import com.ezgroceries.shoppinglist.Repositories.ShoppingListEntity;
import com.ezgroceries.shoppinglist.Services.ShoppingListService;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ShoppingControllerLab06 {
    //Map<UUID, ShoppingListResource> shoppinglists = new HashMap<UUID,ShoppingListResource>();
    @Autowired
    private ShoppingListService shoppingListService;

    @Autowired
    private CocktailDBClient cocktailDBClient;

    /* part 2 create shopping list - database versie*/
    @PostMapping(value = "/shopping-lists", consumes = "application/json", produces = "application/json")
    public ResponseEntity <List<ShoppingListEntity>> create(@RequestBody List<ShoppingListResource> shoppingListResources) throws JsonParseException {
        System.out.println("Part 2");
        List<ShoppingListEntity> shoppingListEntityList = new ArrayList<>();
        ShoppingListEntity shoppingListEntity = new ShoppingListEntity();
        for (ShoppingListResource shoppingListResource2 : shoppingListResources) {
            shoppingListResource2.setShoppingListId(UUID.randomUUID());
            shoppingListEntity.setShoppinglistid(UUID.randomUUID());
            shoppingListEntity.setName(shoppingListResource2.getName());
            shoppingListEntityList.add(shoppingListService.addShoppingList(shoppingListEntity));
        }
        return new ResponseEntity<>(shoppingListEntityList, HttpStatus.CREATED);
    }

    /* Part 3 - add cocktails to list database versie */
    @PostMapping(value = "/shopping-lists/{shoppingListId}/cocktails", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<CocktailEntity>> create(@PathVariable UUID shoppingListId, @RequestBody List<CocktailEntity> cocktailResourceList ) {

        System.out.println("Part 3");

        List<CocktailEntity> cocktailIdList = new ArrayList<>();

        for (CocktailEntity cocktail:cocktailResourceList){
            CocktailId cocktailId = new CocktailId(cocktail.getCocktailId().toString());
            cocktailIdList.add(cocktail);
        }
        if (cocktailIdList != null)
        {
            shoppingListService.setCocktails(shoppingListId,cocktailIdList);
            return new ResponseEntity<>(cocktailIdList,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity(HttpStatus.CONFLICT);

        }
    }

    /* Part 4 - get shopping list database versie*/
    @GetMapping(value = "/shopping-lists/{shoppingListId}", produces = "application/json")
    public ResponseEntity<ShoppingListOut> get(@PathVariable UUID shoppingListId) {

        System.out.println("Part 4");
        ShoppingListEntity shoppingListResource = shoppingListService.readShoppingList(shoppingListId);
        ShoppingListOut shoppingListOut = new ShoppingListOut();
        shoppingListOut.setShoppingListId(shoppingListResource.getShoppinglistid());
        shoppingListOut.setName(shoppingListResource.getName());

        return new ResponseEntity<>(shoppingListOut,HttpStatus.OK);
    }
}
package com.ezgroceries.shoppinglist.Controllers;

import com.ezgroceries.shoppinglist.Controllers.ResourceCocktail.CocktailId;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListOut;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListResource;
import com.ezgroceries.shoppinglist.Repositories.*;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingControllerLab06 {
    /* part 2 create shopping list - database versie*/
    @PostMapping(value = "/shopping-lists", consumes = "application/json", produces = "application/json")
    public ResponseEntity <List<ShoppingListEntity>> create(@RequestBody List<ShoppingListResource> shoppingListResources) throws JsonParseException {
        List<ShoppingListEntity> shoppingListEntityList = new ArrayList<>();
        ShoppingListEntity shoppingListEntity = new ShoppingListEntity();
        for (ShoppingListResource shoppingListResource2 : shoppingListResources) {
            shoppingListResource2.setShoppingListId(UUID.randomUUID());
            shoppingListEntity.setShoppingListID(UUID.randomUUID());
            shoppingListEntity.setName(shoppingListResource2.getName());
            shoppingListEntityList.add(shoppingListService.addShoppingList(shoppingListEntity));
        }
        return new ResponseEntity<>(shoppingListEntityList, HttpStatus.CREATED);
    }

    /* Part 3 - add cocktails to list database versie */
    @PostMapping(value = "/shopping-lists/{shoppingListId}/cocktails", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<CocktailEntity>> create(@PathVariable UUID shoppingListId, @RequestBody List<CocktailEntity> cocktailResourceList ) {

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
        shoppingListOut.setShoppingListId(shoppingListResource.getShoppingListID());
        shoppingListOut.setName(shoppingListResource.getName());
        //ShoppingListOut shoppingListOut = LoopThroughCocktails(shoppingListResource);

        return new ResponseEntity<>(shoppingListOut,HttpStatus.OK);
    }
}

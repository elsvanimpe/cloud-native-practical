package com.ezgroceries.shoppinglist.Controllers;

import com.ezgroceries.shoppinglist.Controllers.ResourceCocktail.CocktailId;
import com.ezgroceries.shoppinglist.Controllers.ResourceCocktail.CocktailResource;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListOut;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListResource;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ezgroceries.shoppinglist.Services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
public class ShoppingController {
    /* part 2 create shopping list */
    @PostMapping(value = "/shopping-lists", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<ShoppingListResource>> create(@RequestBody List<ShoppingListResource> shoppingListResources) throws JsonParseException {
        System.out.println("Part 2");
        List<ShoppingListResource> shoppingListResourceList = new ArrayList<>();
        for (ShoppingListResource shoppingListResource2 : shoppingListResources) {
            shoppingListResource2.setShoppingListId(UUID.randomUUID());
            shoppinglists.put(shoppingListResource2.getShoppingListId(), shoppingListResource2);
            shoppingListResourceList.add(shoppingListResource2);
        }
        return new ResponseEntity<>(shoppingListResourceList, HttpStatus.CREATED);
    }

    /* Part 3 - add cocktails to list */
    @PostMapping(value = "/shopping-lists/{shoppingListId}/cocktails", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<CocktailId>> create(@PathVariable UUID shoppingListId, @RequestBody List<CocktailResource> cocktailResourceList ) {

        System.out.println("Part 3");

        List<CocktailId> cocktailIdList = new ArrayList<>();
        ShoppingListResource shoppingListResource = shoppinglists.get(shoppingListId);

        for (CocktailResource cocktail:cocktailResourceList){
            CocktailId cocktailId = new CocktailId(cocktail.getCocktailId());
            cocktailIdList.add(cocktailId);
        }
        if (cocktailIdList != null)
        {
            shoppingListResource.setCocktails(cocktailIdList);
            return new ResponseEntity<>(cocktailIdList,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity(HttpStatus.CONFLICT);

        }
    }

    /* Part 4 - get shopping list */
    @GetMapping(value = "/shopping-lists/{shoppingListId}", produces = "application/json")
    public ResponseEntity<ShoppingListOut> get(@PathVariable UUID shoppingListId) {

        System.out.println("Part 4");
        ShoppingListResource shoppingListResource = shoppinglists.get(shoppingListId);
        ShoppingListOut shoppingListOut = LoopThroughCocktails(shoppingListResource);
        return new ResponseEntity<>(shoppingListOut,HttpStatus.OK);
    }
    /* Part 5 - get all shopping lists */
    @GetMapping(value = "/shopping-listsall", produces = "application/json")
    public ResponseEntity<List<ShoppingListOut>> get() {

        System.out.println("Part 5");
        Set<UUID> keys = shoppinglists.keySet();
        List<ShoppingListOut> shoppingListOuts = new ArrayList<>();

        for(int j=0;j<shoppinglists.size();j++){
            UUID key = (UUID) keys.toArray()[j];
            System.out.println("key > " + key + "  : value = " + shoppinglists.get(key));
            ShoppingListResource shoppingListResource = shoppinglists.get(key);
            ShoppingListOut shoppingListOut = LoopThroughCocktails(shoppingListResource);
            shoppingListOuts.add(shoppingListOut);
        }
        return new ResponseEntity<>(shoppingListOuts,HttpStatus.OK);
    }

    private ShoppingListOut LoopThroughCocktails(ShoppingListResource shoppingListResource){

        List<String> shoppingListIngredients = new ArrayList<>();
        List<CocktailResource> cocktailResources = getDummyResources();
        List<CocktailId> cocktailIdList = shoppingListResource.getCocktails();
        ShoppingListOut shoppingListOut = new ShoppingListOut();
        shoppingListOut.setShoppingListId(shoppingListResource.getShoppingListId());
        shoppingListOut.setName(shoppingListResource.getName());
        shoppingListIngredients.clear();
        for (CocktailId cocktailId :cocktailIdList){
            for(CocktailResource cocktailResource : cocktailResources)
            {
                if (cocktailResource.getCocktailId().equals(cocktailId.getCocktailId())) {
                    for(String ingredient : cocktailResource.getIngredients())
                    {
                        shoppingListIngredients.add(ingredient);
                    }
                }
            }
            shoppingListOut.setShoppingListIngredientList(shoppingListIngredients);
        }
        return shoppingListOut;
    }
}

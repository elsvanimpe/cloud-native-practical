package com.ezgroceries.shoppinglist.Controllers;

import com.ezgroceries.shoppinglist.Controllers.ResourceCocktail.CocktailId;
import com.ezgroceries.shoppinglist.Controllers.ResourceCocktail.CocktailResource;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListOut;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.ShoppingListResource;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CocktailController {
    Map<UUID, ShoppingListResource> shoppinglists = new HashMap<UUID,ShoppingListResource>();
    /* part 1 get cocktails */
    @GetMapping(value = "/cocktails", produces = "application/json")
    public ResponseEntity<List<CocktailResource>> get(@RequestParam String search) {
        System.out.println("Part 1");

        return ResponseEntity.ok((getDummyResources()));
    }

    private List<CocktailResource> getDummyResources() {
        return Arrays.asList(
                new CocktailResource(
                        UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"), "Margerita",
                        "Cocktail glass",
                        "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
                        "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
                        Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt")),
                new CocktailResource(
                        UUID.fromString("d615ec78-fe93-467b-8d26-5d26d8eab073"), "Blue Margerita",
                        "Cocktail glass",
                        "Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..",
                        "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
                        Arrays.asList("Tequila", "Blue Curacao", "Lime juice", "Salt")));
    }

    /* part 2 create shopping list */
    @PostMapping(value = "/shopping-lists", consumes = "application/json", produces = "application/json")
    public ResponseEntity <List<ShoppingListResource>> create(@RequestBody List<ShoppingListResource> shoppingListResources) throws JsonParseException {
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
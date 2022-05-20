package com.ezgroceries.shoppinglist.Controllers;


import com.ezgroceries.shoppinglist.Controllers.ResourceCocktail.*;
import com.ezgroceries.shoppinglist.Controllers.ResourceShopping.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ezgroceries.shoppinglist.Services.*;

import java.util.*;

@RestController
public class CocktailController {
    Map<UUID, ShoppingListResource> shoppinglists = new HashMap<UUID,ShoppingListResource>();
    /* part 1 get cocktails */
    @GetMapping(value = "/cocktails", produces = "application/json")
    public ResponseEntity<List<CocktailResource>> get(@RequestParam String search) {
        System.out.println("Part 1");

        return ResponseEntity.ok((Functions.getDummyResources()));
    }


}
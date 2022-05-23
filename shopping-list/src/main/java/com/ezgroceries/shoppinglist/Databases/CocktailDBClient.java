package com.ezgroceries.shoppinglist.Databases;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "cocktailDBClient", url = "https://www.thecocktaildb.com/api/json/v1/1")
// an implementation class is not necessary. @component zorgt ervoor dat die autowired werkt, @feign maakt de implementatie van je interface
public interface CocktailDBClient {

    @GetMapping(value = "search.php")
    CocktailDBResponse searchCocktails(@RequestParam("s") String search);

    @GetMapping(value = "search.php")
    CocktailDBResponse searchAllCocktails();

}

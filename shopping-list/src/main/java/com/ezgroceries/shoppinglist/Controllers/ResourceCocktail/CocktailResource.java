package com.ezgroceries.shoppinglist.Controllers.ResourceCocktail;

import java.util.*;

public class CocktailResource {
     /* for lab02
     private UUID cocktailId; */

    // for lab04
    private String cocktailId;

    private String name;
    private String glass;
    private String instructions;
    private String image;
    private List<String> ingredients;


    /* No args constructor */
    public CocktailResource() {
    }

    /* All args constructor lab 02
    public CocktailResource(UUID cocktailId, String name, String glass, String instructions, String image,
                            List<String> ingredients) {
        this.cocktailId = cocktailId;
        this.name = name;
        this.glass = glass;
        this.instructions = instructions;
        this.image = image;
        this.ingredients = ingredients;
    }
    public UUID getCocktailId() {
        return cocktailId;
    }
    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    } */

    // All args constructor lab 04
    public CocktailResource(String cocktailId, String name, String glass, String instructions, String image,
                            List<String> ingredients) {
        this.cocktailId = cocktailId;
        this.name = name;
        this.glass = glass;
        this.instructions = instructions;
        this.image = image;
        this.ingredients = ingredients;
    }
    public String getCocktailId() {
        return cocktailId;
    }
    public void setCocktailId(String cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGlass() {
        return glass;
    }
    public void setGlass(String glass) {
        this.glass = glass;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }



}
















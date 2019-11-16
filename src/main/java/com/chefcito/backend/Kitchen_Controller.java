package com.chefcito.backend;

import com.chefcito.entities.Ingredient;
import com.chefcito.entities.Recipe;
import com.chefcito.entities.Recipe_Ingredient;
import com.chefcito.repositories.Ingredient_Repository;
import com.chefcito.repositories.Recipe_Ingredient_Repository;
import com.chefcito.repositories.Recipe_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController

public class Kitchen_Controller {

    @Autowired
    private Ingredient_Repository ingredient_repository;

    @Autowired
    private Recipe_Repository recipe_repository;

    @Autowired
    private Recipe_Ingredient_Repository recipe_ingredient_repository;

    @GetMapping("/ingredients")
    public List<Ingredient> getIngredients(){
        List ingredients =  ingredient_repository.findAll();
        return ingredients;
    }

    @GetMapping("/ingredient/{name}")
    public List<Ingredient> searchIngredients(@PathVariable String name){
        return ingredient_repository.findAllByNameContains(name);
    }

    @PostMapping("/search/recipe")
    public Set<Recipe> getRecipeByIngredients(@RequestBody List<Ingredient> ingredients){
        Set<Recipe> result = new HashSet<>();
        List<Recipe_Ingredient> recipe = recipe_ingredient_repository.findAll();

        for (int i = 0; i < recipe.size(); i++) {
            for (int j = 0; j < ingredients.size(); j++) {
                if(recipe.get(i).getIngredient().getName().equals(ingredients.get(j).getName())){
                    result.add(recipe.get(i).getRecipe());
                    break;
                }
            }
        }

        return result;
    }

}

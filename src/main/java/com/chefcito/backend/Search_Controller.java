package com.chefcito.backend;

import com.chefcito.entities.Ingredient;
import com.chefcito.entities.RI_ID;
import com.chefcito.entities.Recipe;
import com.chefcito.entities.Recipe_Ingredient;
import com.chefcito.repositories.Ingredient_Repository;
import com.chefcito.repositories.Recipe_Ingredient_Repository;
import com.chefcito.repositories.Recipe_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Search_Controller {

    @Autowired
    Recipe_Repository recipe_repository;

    @Autowired
    Recipe_Ingredient_Repository recipe_ingredient_repository;

    @Autowired
    Ingredient_Repository ingredient_repository;

    @GetMapping("/search/title/{title}")
    public List<Recipe> search(@PathVariable String title){
        return recipe_repository.findAllByTitleContains(title);
    }

    @GetMapping("/recipe/ingredients/{id}")
    public List<Ingredient> getIngredients(@PathVariable int id) {
        List<Ingredient> ingredients = new ArrayList<>();
        List<Recipe_Ingredient> recipes = recipe_ingredient_repository.findAllByIdRecipe(recipe_repository.getOne(id));

        for (int i = 0; i < recipes.size(); i++)
            ingredients.add(recipes.get(i).getIngredient());

        return ingredients;
    }

    @GetMapping("recipe/amount/{rId}/{name}")
    public String getAmount(@PathVariable int rId, @PathVariable String name){
        List<Recipe_Ingredient> recipe = recipe_ingredient_repository.findAllByIdRecipe(recipe_repository.getOne(rId));
        Ingredient ingredient = ingredient_repository.findByName(name);

        for (int i = 0; i < recipe.size(); i++) {
            if(ingredient.getName().equals(recipe.get(i).getIngredient().getName()))
                return recipe.get(i).getAmount();
        }

        return "";
    }

}

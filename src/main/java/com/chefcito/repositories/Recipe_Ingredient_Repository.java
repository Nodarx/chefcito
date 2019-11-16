package com.chefcito.repositories;

import com.chefcito.entities.RI_ID;
import com.chefcito.entities.Recipe;
import com.chefcito.entities.Recipe_Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Recipe_Ingredient_Repository extends JpaRepository<Recipe_Ingredient, RI_ID> {
    List<Recipe_Ingredient> findAllByIdRecipe(Recipe recipe);
}

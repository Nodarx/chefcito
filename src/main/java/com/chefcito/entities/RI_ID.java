package com.chefcito.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RI_ID implements Serializable {

    @ManyToOne(optional = false)
    private Recipe recipe;

    @ManyToOne(optional = false)
    private Ingredient ingredient;

    public RI_ID(){
    }

    public RI_ID(Recipe recipe, Ingredient ingredient){
        setRecipe(recipe);
        setIngredient(ingredient);
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    private void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    private void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

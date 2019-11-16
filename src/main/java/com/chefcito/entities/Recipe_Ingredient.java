package com.chefcito.entities;

import javax.persistence.*;

@Entity
@Table(name = "RECIPE_INGREDIENT")
public class Recipe_Ingredient {

    @EmbeddedId
    private RI_ID id;

    @Column(name = "Amount", nullable = false)
    private String amount;

    public Recipe_Ingredient(){
    }

    public Recipe_Ingredient(Recipe recipe, Ingredient ingredient, String amount){
        setId(new RI_ID(recipe,ingredient));
        setAmount(amount);
    }

    public RI_ID getId() {
        return id;
    }

    public Ingredient getIngredient(){
        return id.getIngredient();
    }

    public Recipe getRecipe(){
        return id.getRecipe();
    }

    public String getAmount() {
        return amount;
    }

    private void setId(RI_ID id){
        this.id = id;
    }

    private void setAmount(String amount) {
        this.amount = amount;
    }
}


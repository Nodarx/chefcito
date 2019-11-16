package com.chefcito.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class KP_ID implements Serializable {

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Recipe recipe;

    public KP_ID(){
    }

    public KP_ID(User user, Recipe recipe){
        setUser(user);
        setRecipe(recipe);
    }

    public User getUser() {
        return user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    private void setUser(User user) {
        this.user = user;
    }

    private void setRecipe(Recipe recipe) {
        this.recipe = recipe;
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

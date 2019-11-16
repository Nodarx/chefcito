package com.chefcito.entities;

import javax.persistence.*;

@Entity
@Table(name = "KEEP")
public class Keep{

    @EmbeddedId
    private KP_ID id;

    public Keep(){
    }

    public  Keep(User user, Recipe recipe){
        setId(new KP_ID(user,recipe));
    }

    public KP_ID getId() {
        return id;
    }

    public User getUser(){
        return id.getUser();
    }

    public Recipe geRecipe(){
        return id.getRecipe();
    }

    private void setId(KP_ID id){
        this.id = id;
    }

}

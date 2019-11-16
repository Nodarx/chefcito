package com.chefcito.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ingredient_Id")
    private int id;

    @Column(name = "Name", nullable = false, unique = true)
    @Length(min = 5, max = 20)
    private String name;

    @Column(name = "Calories", nullable = false)
    private int calories;

    @Column(name = "Price", nullable = false)
    private int price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.ingredient")
    private List<Recipe_Ingredient> recipe;

    public Ingredient(){
    }

    public Ingredient(String name, int calories, int price){
        setName(name);
        setCalories(calories);
        setPrice(price);
    }

    public Ingredient(int id,String name, int calories, int price){
        this.id = id;
        setName(name);
        setCalories(calories);
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getPrice() {
        return price;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCalories(int calories) {
        this.calories = calories;
    }

    private void setPrice(int price) {
        this.price = price;
    }

}

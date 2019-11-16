package com.chefcito.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "RECIPE")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Recipe_Id")
    private int id;

    @Column(name = "Title", nullable = false, unique = true)
    @Length(min = 5, max = 20)
    private String title;

    @Column(name = "Type", nullable = false)
    @Length(min = 5, max = 15)
    private String type;

    @Column(name = "Tag", nullable = false)
    @Length(min = 3, max = 10)
    private String tag;

    @Column(name = "Description", nullable = false, columnDefinition = "Text")
    @Length(min = 10, max = 100)
    private String description;

    @Column(name = "Instructions", nullable = false, columnDefinition = "Text")
    @Length(min = 10, max = 100)
    private String instructions;

    @Column(name = "Video", nullable = false, unique = true)
    @Length(min = 10, max = 50)
    private String video;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.recipe")
    private List<Recipe_Ingredient> ingredients;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "id.recipe")
    private List<Keep> keeps;

    public Recipe(){
    }

    public Recipe(String title, String type, String tag, String description, String instructions, String video){
        setTitle(title);
        setType(type);
        setTag(tag);
        setDescription(description);
        setInstructions(instructions);
        setVideo(video);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getVideo() {
        return video;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setType(String type){
        this.type = type;
    }

    private void setTag(String tag){
        this.tag = tag;
    }

    private void setDescription(String description){
        this.description = description;
    }

    private void setInstructions(String instructions){
        this.instructions = instructions;
    }

    private void setVideo(String url){
        this.video = url;
    }

}


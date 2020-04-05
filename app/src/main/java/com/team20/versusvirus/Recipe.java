package com.team20.versusvirus;

import java.security.Timestamp;
import java.util.List;

public class  Recipe{
    public Integer id_Recipe,prepTim,cookTime,difficulty,numberParticipent;
    public String image,title, language,description;
    public Timestamp date;
    public List<Ingredient> ingredients;
    public List<String> steps;

    public Recipe(Integer id_Recipe, Integer prepTim, Integer cookTime, Integer difficulty, Integer numberParticipent, String image, String title, String language, String description, Timestamp date) {
        this.id_Recipe = id_Recipe;
        this.prepTim = prepTim;
        this.cookTime = cookTime;
        this.difficulty = difficulty;
        this.numberParticipent = numberParticipent;
        this.image = image;
        this.title = title;
        this.language = language;
        this.description = description;
        this.date = date;
    }

    public Recipe() {}
}
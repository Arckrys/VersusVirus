package com.team20.versusvirus;

import java.util.List;

public class User{
    public String description, password, username, email, name, birthday, photo, language;
    public List<Recipe> upcomingRecipe, createdRecipe, pastRecipe;
    public List<String> friends_id;

    public User(String description, String password, String username, String email, String name, String birthday, String photo, String language) {
        this.description = description;
        this.password = password;
        this.username = username;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.photo = photo;
        this.language = language;
    }

    public User() {}
}

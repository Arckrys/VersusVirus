package com.team20.versusvirus;

import java.util.List;

public class User  {

    public String name;
    public String description;
    public List<String> passions;

    public User(String name, String description, List<String> passions) {
        this.name = name;
        this.description = description;
        this.passions = passions;
    }

    // EMPTY CONSTRUCTOR IS REQUIRED FOR dataSnapshot.getValue
    public User() {

    }

}

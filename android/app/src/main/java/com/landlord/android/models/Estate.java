package com.landlord.android.models;

import java.io.Serializable;

public class Estate implements Serializable {
    public String imageUrl;
    public int id;
    public String name;
    public String description;

    public Estate() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Estate(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

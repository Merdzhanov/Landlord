package com.landlord.models;


import com.landlord.models.base.ModelBase;
import com.landlord.models.base.UserType;

import java.util.LinkedList;
import java.util.List;

public class User extends ModelBase {
    private Double rating;
    private UserType userType;
    private List<Estate> estates;

    public User() {

    }

    public User(String userName, Double rating, UserType userType) {
        this.setId(userName);
        this.rating = rating;
        this.userType = userType;
        this.estates = new LinkedList<>();
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}

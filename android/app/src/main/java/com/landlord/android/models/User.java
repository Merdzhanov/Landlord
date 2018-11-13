package com.landlord.android.models;

import com.landlord.android.models.base.UserType;
import java.io.Serializable;

public class User implements Serializable {
    public int id;
    public String userName;
    public float rating;
    public UserType userType;
    public String firstName;
    public String lastName;

    public User() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public User(int id, String userName, String firstName, String lastName, float rating, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.rating = rating;
        this.userType = userType;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}



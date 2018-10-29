package com.landlord.android.models;

import com.landlord.android.models.base.UserType;
import java.io.Serializable;

public class User implements Serializable {
    public int id;
    public String userName;
    public float rating;
    public UserType userType;
    //public List<Estate> estates;
    //private List<ChatMessage> messages;

    public User() {
        // public constructor is needed for parsing from/to JSON to work
    }

    public User(int id, String userName, float rating, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.rating = rating;
        this.userType = userType;
        //this.estates = new ArrayList<Estate>();
        //this.messages = new LinkedList<ChatMessage>();
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



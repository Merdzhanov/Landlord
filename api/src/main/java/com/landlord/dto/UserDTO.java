package com.landlord.dto;

import com.landlord.dto.base.DTOModelBase;
import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.base.UserType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class UserDTO extends DTOModelBase {
    public String userName;
    public Double rating;
    public UserType userType;
    public List<Estate> estates;
    public List<ChatMessage> messages;

    public UserDTO() {

    }

    public UserDTO(int id, String userName, Double rating, UserType userType) {
        this.id = id;
        this.userName=userName;
        this.rating = rating;
        this.userType = userType;
        this.estates = new ArrayList<Estate>();
        this.messages = new LinkedList<ChatMessage>();
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

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }


}

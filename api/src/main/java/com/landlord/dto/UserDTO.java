package com.landlord.dto;

import com.landlord.dto.base.DTOModelBase;
import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.models.base.UserType;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class UserDTO extends DTOModelBase {
    public String userName;
    public float rating;
    public UserType userType;
    public List<EstateDTO> estates;
    public String firstName;
    public String lastName;
    //public List<ChatMessageDTO> messages;

    public UserDTO() {

    }

    public UserDTO(int id, String userName,String firstName,String lastName, float rating, UserType userType) {
        this.id = id;
        this.userName=userName;
        this.rating = rating;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        //this.estates = new ArrayList<EstateDTO>();
        //this.messages = new LinkedList<ChatMessageDTO>();
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

//    public List<EstateDTO> getEstates() {
//        return estates;
//    }
//
//    public void setEstates(List<EstateDTO> estates) {
//        this.estates = estates;
//    }

//    public List<ChatMessageDTO> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<ChatMessageDTO> messages) {
//        this.messages = messages;
//    }


}

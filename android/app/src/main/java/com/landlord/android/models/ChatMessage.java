package com.landlord.android.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatMessage {
    public int id;
    private String message;
    private User sender;
    private Date date;//messageTime;
    private Estate estate;
   // private List<Estate> estates;


    public ChatMessage(int id, String message, User sender, Date date,Estate estate) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.date = date;
        this.estate=estate;
    }

    public ChatMessage(String message, User sender, Estate estate) {
        this.message = message;
        this.sender = sender;
        this.estate=estate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }
}

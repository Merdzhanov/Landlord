package com.landlord.android.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatMessage {
    public int id;
    private String message;//messageText;
    private User sender;//messageUser;
    private Date date;//messageTime;
   // private List<Estate> estates;


    public ChatMessage(int id, String message, User sender, Date date) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.date = date;
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

//    public ChatMessage(String massageText, String messageUser) {
//        this.messageText = massageText;
//        this.messageUser = messageUser;
//        messageTime = new Date();
////        this.estates = new ArrayList<Estate>();
//    }
//
//    public ChatMessage() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getMessageText() {
//        return messageText;
//    }
//
//    public void setMessageText(String messageText) {
//        this.messageText = messageText;
//    }
//
//    public String getMessageUser() {
//        return messageUser;
//    }
//
//    public void setMessageUser(String messageUser) {
//        this.messageUser = messageUser;
//    }
//
//    public Date getMessageTime() {
//        return messageTime;
//    }
//
//    public void setMessageTime(Date messageTime) {
//        this.messageTime = messageTime;
//    }
//
////    public List<Estate> getEstates() {
////        return estates;
////    }
////
////    public void setEstates(List<Estate> estates) {
////        this.estates = estates;
////    }
}

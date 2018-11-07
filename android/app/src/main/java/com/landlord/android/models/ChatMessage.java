package com.landlord.android.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatMessage {
    public int id;
    private String messageText;
    private String messageUser;
    private Date messageTime;
    private List<Estate> estates;

    public ChatMessage(String massageText, String messageUser) {
        this.messageText = massageText;
        this.messageUser = messageUser;
        messageTime = new Date();
        this.estates = new ArrayList<Estate>();
    }

    public ChatMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }
}

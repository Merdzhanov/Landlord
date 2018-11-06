package com.landlord.android.models;

import java.util.Date;

public class ChatMessage {
    public static int id;
    private String messageText;
    private String messageUser;
    private long messageTime;

    public ChatMessage(String massageText, String messageUser) {
        this.messageText = massageText;
        this.messageUser = messageUser;
        messageTime = new Date().getTime();
    }

    public ChatMessage() {
    }

    public static int getId() {
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

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}

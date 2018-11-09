package com.landlord.android.models;

import java.util.Date;

import dagger.Provides;

public class ChatMessageDTO {
    private String message;//messageText;
    private String messageSenderUsername;//messageUser;
    private String estateId;

    public ChatMessageDTO(String message, String messageSenderUsername, String estateId) {
        this.message = message;
        this.messageSenderUsername = messageSenderUsername;
        this.estateId = estateId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageSenderUsername() {
        return messageSenderUsername;
    }

    public void setMessageSenderUsername(String messageSender) {
        this.messageSenderUsername = messageSender;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }
}

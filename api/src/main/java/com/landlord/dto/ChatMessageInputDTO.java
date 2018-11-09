package com.landlord.dto;

import com.landlord.dto.base.DTOModelBase;

import java.util.Date;


public class ChatMessageInputDTO extends DTOModelBase {
    public String message;
    public String estateId;
    public String messageSenderUsername;

    public ChatMessageInputDTO() {
    }

    public ChatMessageInputDTO(String message, String estateId, String username) {
        this.message = message;
        this.estateId = estateId;
        this.messageSenderUsername = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }

    public String getMessageSenderUsername() {
        return messageSenderUsername;
    }

    public void setMessageSenderUsername(String username) {
        this.messageSenderUsername = username;
    }
}

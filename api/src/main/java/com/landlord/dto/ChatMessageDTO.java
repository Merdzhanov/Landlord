package com.landlord.dto;

import com.landlord.dto.base.DTOModelBase;
import java.util.Date;

public class ChatMessageDTO extends DTOModelBase {
    public int id;
    public String message;
    public Date date;
    public EstateDTO estate;
    public UserDTO sender;

    public ChatMessageDTO() {
    }

    public ChatMessageDTO(String message, Date date, EstateDTO estate, UserDTO sender) {
        this.message = message;
        this.date = date;
        this.estate = estate;
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public EstateDTO getEstate() {
        return estate;
    }

    public void setEstate(EstateDTO estate) {
        this.estate = estate;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }
}

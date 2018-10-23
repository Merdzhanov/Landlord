package com.landlord.models;

import java.util.Date;

public class ChatMessage {
    private String message;
    private String tenantUserName;
    private String landlordUserName;
    private Date date;
    private String sender;


    public ChatMessage() {
    }

    public ChatMessage(String message, String tenantUserName, String landlordUserName, Date date, String sender) {
        this.message = message;
        this.tenantUserName = tenantUserName;
        this.landlordUserName = landlordUserName;
        this.date = date;
        this.sender = sender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTenantUserName() {
        return tenantUserName;
    }

    public void setTenantUserName(String tenantUserName) {
        this.tenantUserName = tenantUserName;
    }

    public String getLandlordUserName() {
        return landlordUserName;
    }

    public void setLandlordUserName(String landlordUserName) {
        this.landlordUserName = landlordUserName;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

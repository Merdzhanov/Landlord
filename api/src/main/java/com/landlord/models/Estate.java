package com.landlord.models;

import com.landlord.models.base.ModelBase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Estate  extends ModelBase {
    private String description;
    private String address;
    private User landlord;
    private BigDecimal owedAmount;
    private Date dueDate;
    private List<ChatMessage> messageList;

    public Estate(String description, String address, User landlord, BigDecimal owedAmount, Date dueDate) {
        this.description = description;
        this.address = address;
        this.landlord = landlord;
        this.owedAmount = owedAmount;
        this.dueDate = dueDate;
        this.messageList=new LinkedList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getLandlord() {
        return landlord;
    }

    public void setLandlord(User landlord) {
        this.landlord = landlord;
    }

    public BigDecimal getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(BigDecimal owedAmount) {
        this.owedAmount = owedAmount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<ChatMessage> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<ChatMessage> messageList) {
        this.messageList = messageList;
    }
}

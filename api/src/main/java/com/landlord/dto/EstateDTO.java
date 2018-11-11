package com.landlord.dto;

import com.landlord.dto.base.DTOModelBase;
import com.landlord.models.ChatMessage;
import com.landlord.models.User;
import com.landlord.models.base.ModelBase;
import com.mysql.jdbc.Blob;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EstateDTO extends DTOModelBase {
    public int id;
    public String imageUrl;
    public byte[] image;
    public String name;
    public String description;
    public String address;
    public BigDecimal monthlyRent;
    public BigDecimal owedAmount;
    public Date dueDate;
    public List<UserDTO> users;
    public List<ChatMessageDTO> messageList;

    public EstateDTO() {
    }

    public EstateDTO(String description, byte[] image, String address, BigDecimal monthlyRent, BigDecimal owedAmount, Date dueDate) {
        this.description = description;
        this.image=image;
        this.address = address;
        this.monthlyRent = monthlyRent;
        this.owedAmount = owedAmount;
        this.dueDate = dueDate;
        this.users = new LinkedList<UserDTO>();
        this.messageList = new LinkedList<ChatMessageDTO>();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<ChatMessageDTO> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<ChatMessageDTO> messageList) {
        this.messageList = messageList;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }
}

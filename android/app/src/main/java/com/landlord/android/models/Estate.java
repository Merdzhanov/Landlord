package com.landlord.android.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estate implements Serializable {
    public int id;
    public String imageUrl;
    public byte[] image;
    public String name;
    public String description;
    private String address;
    private BigDecimal monthlyRent;
    private BigDecimal owedAmount;
    private Date dueDate;
    private List<User> users;

    public Estate(int id, String name,  byte[] image, String description, String imageUrl) {
        // public constructor is needed for parsing from/to JSON to work
    }

    public Estate(
            int id,
            String name,
            String description,
            String imageUrl,
            byte[] image,
            String address,
            BigDecimal monthlyRent,
            BigDecimal owedAmount,
            Date dueDate
    )
    {
        this.id=id;
        this.name = name;
        this.image=image;
        this.description = description;
        this.imageUrl = imageUrl;
        this.address=address;
        this.monthlyRent=monthlyRent;
        this.owedAmount=owedAmount;
        this.dueDate=dueDate;
        this.users=new ArrayList<User>();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;

    }
    ///////////////
    public void setId(int id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
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

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
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

    public java.util.List<User> getUsers() {
        return users;
    }

    public void setUsers(java.util.List<User> users) {
        this.users = users;
    }
}

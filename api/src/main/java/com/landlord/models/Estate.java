package com.landlord.models;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@EnableAutoConfiguration
@ComponentScan
@Entity
@Table(name = "estates")
public class Estate {

    @Id
    @Column(name = "EstateID")
    private int estateID;

    @Column(name = "Description", nullable=false)
    private String description;

    @Column(name = "Address", nullable=false)
    private String address;

    @Column(name = "OwedAmount", nullable=false)
    private BigDecimal owedAmount;

    @Column(name = "DueDate")
    private Date dueDate;

    @Column(name= "Landlord", nullable=false)
    private String landlord;

    @Column(name= "Tenant")
    private String tenant;

    //    private List<ChatMessage> messageList;

    public Estate() {
    }

    public Estate(int estateID, String description, String address, String landlord, String tenant, BigDecimal owedAmount, Date dueDate) {
        this.estateID = estateID;
        this.description = description;
        this.address = address;
        this.landlord = landlord;
        this.tenant = tenant;
        this.owedAmount = owedAmount;
        this.dueDate = dueDate;
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

    public String getLandlord() {
        return landlord;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
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

    public int getEstateID() {
        return estateID;
    }

    public void setEstateID(int estateID) {
        this.estateID = estateID;
    }

//    public User getTenant() {
//        return tenant;
//    }
//
//    public void setTenant(User tenant) {
//        this.tenant = tenant;
//    }

//    public List<ChatMessage> getMessageList() {
//        return messageList;
//    }
//
//    public void setMessageList(List<ChatMessage> messageList) {
//        this.messageList = messageList;
//    }
}

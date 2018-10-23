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
    private String estateID;

    @Column(name = "Description")
    private String description;

    @Column(name = "Address")
    private String address;

    @Column(name = "OwedAmount")
    private BigDecimal owedAmount;

    @Column(name = "DueDate")
    private Date dueDate;


//    @ManyToOne
//    @JoinColumn(name="LandlordID", nullable=false)
//    private User landlord;

//    @ManyToOne
//    @JoinColumn(name="TenantID", nullable=false)
//    private User tenant;

    //    private List<ChatMessage> messageList;

    public Estate() {
    }

    public Estate(String estateID, String description, String address, BigDecimal owedAmount, Date dueDate) {
        this.estateID = estateID;
        this.description = description;
        this.address = address;
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

//    public User getLandlord() {
//        return landlord;
//    }
//
//    public void setLandlord(User landlord) {
//        this.landlord = landlord;
//    }

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

    public String getEstateID() {
        return estateID;
    }

    public void setEstateID(String estateID) {
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

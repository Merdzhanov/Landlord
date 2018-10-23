package com.landlord.models;

import java.math.BigDecimal;
import java.util.Date;


public class Estate {

//    @Id
//    @Column(name = "EstateID")
    private String EstateID;

//    @Column(name = "Description")
    private String description;

//    @Column(name = "Address")
    private String address;

//    @Column(name = "OwedAmount")
    private BigDecimal owedAmount;

//    @Column(name = "DueDate")
    private Date dueDate;
//    private List<ChatMessage> messageList;

//    @ManyToOne
//    @JoinColumn(name="LandlordID", nullable=false)
    private User landlord;

//    @ManyToOne
//    @JoinColumn(name="TenantID", nullable=false)
    private User tenant;

    public Estate() {
    }

    public Estate(String description, String address, User landlord, User tenant, BigDecimal owedAmount, Date dueDate) {
        this.description = description;
        this.address = address;
        this.landlord = landlord;
        this.tenant = tenant;
        this.owedAmount = owedAmount;
        this.dueDate = dueDate;
//        this.messageList=new LinkedList<>();
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

    public String getEstateID() {
        return EstateID;
    }

    public void setEstateID(String estateID) {
        EstateID = estateID;
    }

    public User getTenant() {
        return tenant;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }

//    public List<ChatMessage> getMessageList() {
//        return messageList;
//    }
//
//    public void setMessageList(List<ChatMessage> messageList) {
//        this.messageList = messageList;
//    }
}

package com.landlord.models;

import com.landlord.models.base.ModelBase;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@EnableAutoConfiguration
@Table(name = "Estates")
public class Estate implements ModelBase {
    @Id
    @GeneratedValue
    @Column(name = "EstateID")
    private int id;

    @Column(name = "imageUrl")
    public String imageUrl;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Address")
    private String address;

//    @ManyToOne
//    @JoinColumn(name = "UserID")
//    private List<User> user;
    @ManyToMany
    @JoinTable(
            name="UsersEstates",
            joinColumns = @JoinColumn(name="EstateID"),
            inverseJoinColumns = @JoinColumn(name="UserID")
    )
    private List<User> users;

    @Column(name = "OwedAmount")
    private BigDecimal owedAmount;

    @Column(name = "DueDate")
    private Date dueDate;

    @OneToMany(mappedBy = "estate")
    private List<ChatMessage> messageList;

    public Estate() {
    }

    public Estate(String description, String address, List<User> users, BigDecimal owedAmount, Date dueDate, List<ChatMessage> messageList) {
        this.description = description;
        this.address = address;
        this.users = new LinkedList<User>();
        this.owedAmount = owedAmount;
        this.dueDate = dueDate;
        this.messageList = new LinkedList<ChatMessage>();
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
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

//    public List<ChatMessage> getMessageList() {
//        return messageList;
//    }
//
//    public void setMessageList(List<ChatMessage> messageList) {
//        this.messageList = messageList;
//    }

}

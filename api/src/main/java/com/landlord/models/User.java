package com.landlord.models;

import com.landlord.models.base.ModelBase;
import com.landlord.models.base.UserType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@EnableAutoConfiguration
@Table(name = "Users")
public class User implements ModelBase {
    @Id
    @GeneratedValue
    @Column(name = "UserID")
    public int id;

    @Column(name = "UserName")
    public String userName;

    @Column(name="Rating")
    private Double rating;

    @Column(name="UserType")
    private UserType userType;

    //@OneToMany(mappedBy = "user")
    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(
            name="UsersEstates",
            joinColumns = @JoinColumn(name="UserID"),
            inverseJoinColumns = @JoinColumn(name="EstateID")
    )
    private List<Estate> estates;

    @OneToMany(mappedBy = "sender")//,fetch = FetchType.EAGER)
    private List<ChatMessage> messages;

    public User() {

    }

    public User(int id, String userName, Double rating, UserType userType) {
        this.id = id;
        this.userName=userName;
        this.rating = rating;
        this.userType = userType;
        this.estates = new ArrayList<Estate>();
        this.messages = new LinkedList<ChatMessage>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Estate> getEstates() {
        return estates;
    }

    public void setEstates(List<Estate> estates) {
        this.estates = estates;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }


}

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
    private int id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name="Rating")
    public float rating;

    @Column(name="UserType")
    private UserType userType;

    @ManyToMany
    @JoinTable(
            name="UsersEstates",
            joinColumns = @JoinColumn(name="UserID"),
            inverseJoinColumns = @JoinColumn(name="EstateID")
    )
    private List<Estate> estates;

    @OneToMany(mappedBy = "sender")
    private List<ChatMessage> messages;

    @OneToMany(mappedBy = "votedForUser")
    private List<RatingVote> ratingVotes;

    public User() {

    }

    public User(int id, String userName, float rating, UserType userType, String firstName,String lastName) {
        this.id = id;
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.rating = rating;
        this.userType = userType;
        this.estates = new ArrayList<Estate>();
        this.messages = new LinkedList<ChatMessage>();
        this.ratingVotes = new ArrayList<RatingVote>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<RatingVote> getRatingVotes() {
        return ratingVotes;
    }

    public void setRatingVotes(List<RatingVote> ratingVotes) {
        this.ratingVotes = ratingVotes;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating)
    {
        this.rating=rating;
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

package com.landlord.models;

import com.landlord.models.base.ModelBase;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EnableAutoConfiguration
@Table(name = "ChatMessages")
public class ChatMessage implements ModelBase {
    @Id
    @GeneratedValue
    @Column(name = "MessageID", updatable = false, nullable = false, insertable=false)
    public int id;

    @NotNull
    @Column(name="Text")
    private String message;

    @NotNull
    //@GeneratedValue
    @Column(name="Date")
    private Date date;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "EstateID")
    private Estate estate;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "UserID")
    private User sender;


    public ChatMessage() {
    }

    public ChatMessage(String message, Estate estate, User sender) {
        this.message = message;
        this.estate = estate;
        this.sender = sender;
        this.date= new Date();
    }

    public ChatMessage(String message, Date date, Estate estate, User sender) {
        this.message = message;
        this.date = date;
        this.estate = estate;
        this.sender = sender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}

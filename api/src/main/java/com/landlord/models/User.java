package com.landlord.models;


import com.landlord.Constants;
import com.landlord.models.base.UserType;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EnableAutoConfiguration
@ComponentScan
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "UserID")
    private int userId;

    @NotNull
    @UniqueElements
    @Size(min = Constants.USERNAME_VALIDATION_MIN_VALUE, max = Constants.USERNAME_VALIDATION_MAX_VALUE)
    @Column(name = "UserName")
    private String userName;

    @NotNull
    @Column(name = "UserType")
    private UserType userType;

    @NotNull
    @Column(name = "FirstName")
    private String firstName;

    @NotNull
    @Column(name = "LastName")
    private String lastName;

    @NotNull
    @Column(name = "Rating")
    private Double rating;

    @NotNull
    @Column(name = "Picture")
    private byte[] userPicture;

//
//    @OneToMany(mappedBy="users")
//    private Set<Estate> estates;


    public User() {

    }

    public User(@NotNull @UniqueElements @Size(min = Constants.USERNAME_VALIDATION_MIN_VALUE, max = Constants.USERNAME_VALIDATION_MAX_VALUE) String userName, @NotNull UserType userType, @NotNull String firstName, @NotNull String lastName, @NotNull Double rating, @NotNull byte[] userPicture) {
        this.userName = userName;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.userPicture = userPicture;
//        this.estates = estates;
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

//    public Set<Estate> getEstates() {
//        return estates;
//    }
//
//    public void setEstates(Set<Estate> estates) {
//        this.estates = estates;
//    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public byte[] getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(byte[] userPicture) {
        this.userPicture = userPicture;
    }
}

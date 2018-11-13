package com.landlord.models;

import com.landlord.models.base.ModelBase;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EnableAutoConfiguration
@Table(name = "RatingVote")
public class RatingVote implements ModelBase {

    @Id
    @GeneratedValue
    @Column(name = "RatingVoteID")
    private int id;

    @NotNull
    @Column(name="RatingVoted")
    public float ratingVoted;

    @NotNull
    @Column(name="Voter")
    private String voter;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "UserID")
    public User votedForUser;

    @NotNull
    @Column(name = "VotingDate")
    public Date votingDate;

    public RatingVote() {
    }

    public RatingVote(float ratingVoted, String voter,User votedForUser, Date votingDate) {
        this.ratingVoted = ratingVoted;
        this.voter = voter;
        this.votedForUser = votedForUser;
        this.votingDate = votingDate;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public float getRatingVoted() {
        return ratingVoted;
    }

    public void setRatingVoted(float ratingVoted) {
        this.ratingVoted = ratingVoted;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public User getVotedForUser() {
        return votedForUser;
    }

    public void setVotedForUser(User votedForUser) {
        this.votedForUser = votedForUser;
    }

    public Date getVotingDate() {
        return votingDate;
    }

    public void setVotingDate(Date votingDate) {
        this.votingDate = votingDate;
    }
}

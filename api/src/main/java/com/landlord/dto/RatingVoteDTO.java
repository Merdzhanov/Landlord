package com.landlord.dto;

import com.landlord.dto.base.DTOModelBase;
import com.landlord.models.User;
import com.landlord.models.base.ModelBase;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

public class RatingVoteDTO extends DTOModelBase implements ModelBase {
    public int id;
    private Integer ratingVoted;
    private String voterUsername;
    private String votedForUserUsername;
    private Date votingDate;

    public RatingVoteDTO(Integer ratingVoted, String voter, String votedForUser) {
    //public RatingVote(float ratingVoted, User votedForUser, Date votingDate) {
        this.ratingVoted = ratingVoted;
        this.voterUsername = voter;
        this.votedForUserUsername = votedForUser;
        this.votingDate = new Date();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Integer getRatingVoted() {
        return ratingVoted;
    }

    public void setRatingVoted(Integer ratingVoted) {
        this.ratingVoted = ratingVoted;
    }

    public String getVoterUsername() {
        return voterUsername;
    }

    public void setVoterUsername(String voterUsername) {
        this.voterUsername = voterUsername;
    }

    public String getVotedForUserUsername() {
        return votedForUserUsername;
    }

    public void setVotedForUserUsername(String votedForUserUsername) {
        this.votedForUserUsername = votedForUserUsername;
    }

    public Date getVotingDate() {
        return votingDate;
    }

    public void setVotingDate(Date votingDate) {
        this.votingDate = votingDate;
    }
}

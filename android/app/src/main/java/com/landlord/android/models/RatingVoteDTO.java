package com.landlord.android.models;

import java.util.Date;

public class RatingVoteDTO {
    private Integer ratingVoted;
    private String voterUsername;
    private String votedForUserUsername;

    public RatingVoteDTO(Integer ratingVoted, String voter, String votedForUser) {
        this.ratingVoted = ratingVoted;
        this.voterUsername = voter;
        this.votedForUserUsername = votedForUser;
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
}

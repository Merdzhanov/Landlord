package com.landlord.repositories.base;

import com.landlord.models.RatingVote;

public interface RatingVotesRepository{
    RatingVote getRatingVoteByUsersVoterAndVotedFor(String voterUserName, String votedForUsername);
    float getAverageRatingForUserByUsername(String votedForUsername);
}

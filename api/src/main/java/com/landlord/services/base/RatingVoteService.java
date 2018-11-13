package com.landlord.services.base;

import com.landlord.dto.RatingVoteDTO;
import com.landlord.models.RatingVote;

public interface RatingVoteService {
    void CreateORUpdateRatingVote(RatingVoteDTO ratingVoteDTO);
    RatingVote getRatingVoteByUsersVoterAndVotedFor(String voterUserName, String votedForUsername);
    float getAverageRatingForUserByUsername(String votedForUsername);
}

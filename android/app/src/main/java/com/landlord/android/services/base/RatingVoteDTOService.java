package com.landlord.android.services.base;

import com.landlord.android.models.RatingVoteDTO;

import java.io.IOException;

public interface RatingVoteDTOService {
    RatingVoteDTO createRatingVote(RatingVoteDTO ratingVoteDTO) throws IOException;
}

package com.landlord.android.services;

import com.landlord.android.models.ChatMessageDTO;
import com.landlord.android.models.RatingVoteDTO;
import com.landlord.android.repositories.base.Repository;
import com.landlord.android.services.base.MessagesDTOService;
import com.landlord.android.services.base.RatingVoteDTOService;

import java.io.IOException;

public class HttpRatingVoteDTOService implements RatingVoteDTOService {

    private final Repository<RatingVoteDTO> mRatingVoteDTORepository;

    public HttpRatingVoteDTOService(
            Repository<RatingVoteDTO> ratingVoteDTORepository) {
        this.mRatingVoteDTORepository=ratingVoteDTORepository;
    }

    @Override
    public RatingVoteDTO createRatingVote(RatingVoteDTO ratingVoteDTO) throws IOException {
        return mRatingVoteDTORepository.addRatingVote(ratingVoteDTO);
    }
}

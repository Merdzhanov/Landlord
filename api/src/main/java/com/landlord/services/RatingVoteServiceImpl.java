package com.landlord.services;

import com.landlord.dto.RatingVoteDTO;
import com.landlord.models.RatingVote;
import com.landlord.models.User;
import com.landlord.repositories.base.RatingVotesRepository;
import com.landlord.services.base.GenericService;
import com.landlord.services.base.RatingVoteService;
import com.landlord.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RatingVoteServiceImpl implements RatingVoteService {
    private final RatingVotesRepository mRatingVoteRepository;
    private final GenericService mGenericService;
    private final UserService mUserService;

    @Autowired
    public RatingVoteServiceImpl(
            RatingVotesRepository ratingVoteRepository,
            GenericService genericService,
            UserService userService
    ) {
        mRatingVoteRepository = ratingVoteRepository;
        mGenericService=genericService;
        mUserService = userService;
    }

    @Override
    public void CreateORUpdateRatingVote(RatingVoteDTO ratingVoteDTO) {
        String voterUserName=ratingVoteDTO.getVoterUsername();
        String votedForUsername=ratingVoteDTO.getVotedForUserUsername();
        User votedForUser=mUserService.getByUserName(votedForUsername);
        RatingVote foundRatingVote=getRatingVoteByUsersVoterAndVotedFor(voterUserName,votedForUsername);
        if(foundRatingVote!=null){
            mGenericService.delete(foundRatingVote);
        }
        RatingVote  ratingVoteToReturn = new RatingVote();
        ratingVoteToReturn.setVoter(voterUserName);
        ratingVoteToReturn.setVotedForUser(votedForUser);
        ratingVoteToReturn.setRatingVoted(ratingVoteDTO.getRatingVoted());
        ratingVoteToReturn.setVotingDate(new Date());
        mGenericService.create(ratingVoteToReturn);
        votedForUser.setRating(getAverageRatingForUserByUsername(votedForUsername));
        mGenericService.update(votedForUser.getId(),votedForUser);
    }

    @Override
    public RatingVote getRatingVoteByUsersVoterAndVotedFor(String voterUserName, String votedForUsername){
        return mRatingVoteRepository.getRatingVoteByUsersVoterAndVotedFor(voterUserName,votedForUsername);
    }

    @Override
    public float getAverageRatingForUserByUsername(String votedForUsername) {
        return mRatingVoteRepository.getAverageRatingForUserByUsername(votedForUsername);
    }
}

package com.landlord.services;

import com.landlord.dto.RatingVoteDTO;
import com.landlord.models.RatingVote;
import com.landlord.models.User;
import com.landlord.repositories.base.RatingVotesRepository;
import com.landlord.services.base.GenericService;
import com.landlord.services.base.RatingVoteService;
import com.landlord.services.base.UserService;
import com.landlord.utils.VotingInputMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RatingVoteServiceImpl implements RatingVoteService {

    //private final GenericRepository<RatingVote> mGenericRepository;
    private final RatingVotesRepository mRatingVoteRepository;
    private final VotingInputMapperImpl mVotingInputMapperImpl;
    private final GenericService mGenericService;
    private final UserService mUserService;
   // private final UserMapperImpl userMapper;

    @Autowired
    public RatingVoteServiceImpl(
            RatingVotesRepository ratingVoteRepository,
            VotingInputMapperImpl votingInputMapper,
            GenericService genericService,
            UserService userService
                                // UserMapperImpl userMapper
    ) {
        mRatingVoteRepository = ratingVoteRepository;
        mVotingInputMapperImpl = votingInputMapper;
        mGenericService=genericService;
        mUserService = userService;
       // this.userMapper = userMapper;
    }

//    @Override
//    public RatingVote CreateRatingVoteByUsersVoterAndVotedFor(RatingVoteDTO ratingVoteDTO) {
//        return null;
//    }


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
//        String mode;
//        if(foundRatingVoteToReturn==null) {
//            ratingVoteToReturn = new RatingVote();
//            mode="create";
//        }else{
//            mode="update";
//        }
        ratingVoteToReturn.setVoter(voterUserName);
        ratingVoteToReturn.setVotedForUser(votedForUser);
        ratingVoteToReturn.setRatingVoted(ratingVoteDTO.getRatingVoted());
        ratingVoteToReturn.setVotingDate(new Date());
        mGenericService.create(ratingVoteToReturn);

        votedForUser.setRating(getAverageRatingForUserByUsername(votedForUsername));
        mGenericService.update(votedForUser.getId(),votedForUser);
//        if(mode.equals("create")){
//            mGenericService.create(ratingVoteToReturn);
//        }else{
//            mGenericService.create(ratingVoteToReturn);
//            GenericService.delete();
//            mGenericService.update(ratingVoteToReturn.getId(),ratingVoteToReturn);
//        }
//
//
//
//        String voterUserName=ratingVoteDTO.getVoterUsername();
//        String votedForUsername=ratingVoteDTO.getVotedForUserUsername();
//        RatingVote ratingVote = getRatingVoteByUsersVoterAndVotedFor(voterUserName, votedForUsername);
//        RatingVote ratingVoteToCreateOrUpdate=mVotingInputMapperImpl.map(ratingVoteDTO);
//        if(ratingVote==null){
//            mGenericService.create(ratingVoteToCreateOrUpdate);
//        }else{
//            mGenericService.update(ratingVoteToCreateOrUpdate.getId(),ratingVoteToCreateOrUpdate);
//        }
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

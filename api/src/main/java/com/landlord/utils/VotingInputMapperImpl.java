package com.landlord.utils;

import com.landlord.dto.RatingVoteDTO;
import com.landlord.models.RatingVote;
import com.landlord.models.User;
import com.landlord.services.base.EstateService;
import com.landlord.services.base.RatingVoteService;
import com.landlord.services.base.UserService;
import com.landlord.utils.base.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
//@Scope("prototype")
public class VotingInputMapperImpl implements DTOMapper<RatingVote, RatingVoteDTO> {
   // private final RatingVoteService mRatingVoteService;
    //private final UserService mUserService;

    @Autowired()
    public VotingInputMapperImpl(
     //       RatingVoteService ratingVoteService,
      //      UserService userService
    ) {
       // mRatingVoteService=ratingVoteService;
        //mUserService=userService;
    }

    @Override
    public RatingVoteDTO map(RatingVote model) {
        return null;
    }

    @Override
    public RatingVote map(RatingVoteDTO dtoModel) {
//        String voterUserName=dtoModel.getVoterUsername();
//        String votedForUsername=dtoModel.getVotedForUserUsername();
//        User votedForUser=mUserService.getByUserName(votedForUsername);
//        RatingVote ratingVoteToReturn=mRatingVoteService.getRatingVoteByUsersVoterAndVotedFor(voterUserName,votedForUsername);
//        if(ratingVoteToReturn==null){
//            ratingVoteToReturn=new RatingVote();
//            ratingVoteToReturn.setVoter(voterUserName);
//            ratingVoteToReturn.setVotedForUser(votedForUser);
//        }
//        ratingVoteToReturn.setRatingVoted(dtoModel.getRatingVoted());
//        ratingVoteToReturn.setVotingDate(new Date());
//        votedForUser.setRating(mRatingVoteService.getAverageRatingForUserByUsername(votedForUsername));
        return null;
    }

    @Override
    public List<RatingVoteDTO> mapMany(List<RatingVote> models) {
        return null;
    }

    @Override
    public List<RatingVote> mapManyToModel(List<RatingVoteDTO> dtoModels) {
        return null;
    }

//    @Override
//    public ChatMessage map(ChatMessageDTO dtoModel) {
//        ChatMessage model = new ChatMessage();
//        model.setId(dtoModel.id);
//        model.setMessage(dtoModel.message);
//        model.setDate(dtoModel.date);
//        //model.setEstate(estateMapper.map(dtoModel.estate));
//        model.setSender(userMapper.map(dtoModel.sender));
//        return model;
//    }

//    @Override
//    public List<ChatMessageInputDTO> mapMany(List<ChatMessage> models) {
//        return null;
////        models.stream()
////            .map(this::map)
////            .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<ChatMessage> mapManyToModel(List<ChatMessageInputDTO> dtoModels) {
//        return null;
//    }

//    @Override
//    public List<ChatMessage> mapManyToModel(List<ChatMessageInputDTO> dtoModels) {
//        return null;
//    }
//
//    @Override
//    public List<ChatMessage> mapManyToModel(List<ChatMessageDTO> dtoModels) {
//        return dtoModels.stream()
//                .map(this::map)
//                .collect(Collectors.toList());
//    }

}

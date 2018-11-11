package com.landlord.utils;

import com.landlord.dto.ChatMessageInputDTO;
import com.landlord.dto.RatingVoteDTO;
import com.landlord.models.ChatMessage;
import com.landlord.models.RatingVote;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.base.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
//@Scope("prototype")
public class VotingInputMapperImpl implements DTOMapper<RatingVote, RatingVoteDTO> {
    private LandlordService mLandlordService;

    @Autowired()
    public VotingInputMapperImpl(
            LandlordService landlordService
            //UserMapperImpl userMapper//,
    //        EstateMapperImpl estateMapper
    ) {
        mLandlordService=landlordService;
       // this.userMapper = userMapper;
    //    this.estateMapper = estateMapper;
    }

    @Override
    public RatingVoteDTO map(RatingVote model) {
//        ChatMessageDTO dtoModel = new ChatMessageDTO();
//        dtoModel.id=model.getId();
//        dtoModel.message=model.getMessage();
//        dtoModel.date=model.getDate();
//        //dtoModel.estate=estateMapper.map(model.getEstate());
//        dtoModel.sender=userMapper.map(model.getSender());
//        return dtoModel;
        return null;
    }

    @Override
    public RatingVote map(RatingVoteDTO dtoModel) {
        //String voterUsername=dtoModel.getVoterUsername();
        //String votedForUsername=dtoModel.getVotedForUserUsername();
        RatingVote ratingVote=mLandlordService.CreateRatingVoteByUsersVoterAndVotedFor(dtoModel);
        return ratingVote;
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

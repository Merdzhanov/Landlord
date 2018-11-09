package com.landlord.utils;

import com.landlord.dto.ChatMessageDTO;
import com.landlord.dto.ChatMessageInputDTO;
import com.landlord.models.ChatMessage;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.base.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
//@Scope("prototype")
public class ChatMessageInputMapperImpl implements DTOMapper<ChatMessage, ChatMessageInputDTO> {
    private LandlordService mLandlordService;
//    private final UserMapperImpl userMapper;
    //private final EstateMapperImpl estateMapper;

    @Autowired()
    public ChatMessageInputMapperImpl(
            LandlordService landlordService
            //UserMapperImpl userMapper//,
    //        EstateMapperImpl estateMapper
    ) {
        mLandlordService=landlordService;
       // this.userMapper = userMapper;
    //    this.estateMapper = estateMapper;
    }

    @Override
    public ChatMessageInputDTO map(ChatMessage model) {
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
    public ChatMessage map(ChatMessageInputDTO dtoModel) {
        ChatMessage model = new ChatMessage();
        //model.setId(dtoModel.id);
        model.setMessage(dtoModel.message);
        model.setDate(new Date());
        model.setEstate(mLandlordService.getEstateByID(Integer.parseInt(dtoModel.estateId)));
        model.setSender(mLandlordService.getByUserName(dtoModel.messageSenderUsername));
        return model;
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

    @Override
    public List<ChatMessageInputDTO> mapMany(List<ChatMessage> models) {
        return null;
//        models.stream()
//            .map(this::map)
//            .collect(Collectors.toList());
    }

    @Override
    public List<ChatMessage> mapManyToModel(List<ChatMessageInputDTO> dtoModels) {
        return null;
    }

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

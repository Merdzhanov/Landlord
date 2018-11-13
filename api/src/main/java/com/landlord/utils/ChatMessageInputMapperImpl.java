package com.landlord.utils;

import com.landlord.dto.ChatMessageInputDTO;
import com.landlord.models.ChatMessage;
import com.landlord.models.Estate;
import com.landlord.services.base.EstateService;
import com.landlord.services.base.GenericService;
import com.landlord.services.base.UserService;
import com.landlord.utils.base.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
//@Scope("prototype")
public class ChatMessageInputMapperImpl implements DTOMapper<ChatMessage, ChatMessageInputDTO> {
    //private EstateService mLandlordService;
    private GenericService mGenericService;
    private UserService mUserService;
    private EstateService mEstateService;
    private final UserMapperImpl mUserMapper;
    private final EstateMapperImpl mEstateMapper;
    //private final EstateMapperImpl estateMapper;

    @Autowired()
    public ChatMessageInputMapperImpl(
            GenericService genericService,
            UserService userService,
            UserMapperImpl userMapper,
            EstateService estateService,
            EstateMapperImpl estateMapper
    //        EstateMapperImpl estateMapper
    ) {
        mGenericService=genericService;
        mUserService=userService;
        mUserMapper = userMapper;
        mEstateService = estateService;
        mEstateMapper = estateMapper;
    //    this.estateMapper = estateMapper;
    }

    @Override
    public ChatMessageInputDTO map(ChatMessage model) {
        return null;
    }

    @Override
    public ChatMessage map(ChatMessageInputDTO dtoModel) {
        ChatMessage model = new ChatMessage();
        //model.setId(dtoModel.id);
        model.setMessage(dtoModel.message);
        model.setDate(new Date());
        model.setEstate(mEstateMapper.map(mEstateService.getEstateByID(Integer.parseInt(dtoModel.estateId))));
        model.setSender(mUserService.getByUserName(dtoModel.messageSenderUsername));
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

package com.landlord.utils;

import com.landlord.dto.ChatMessageDTO;
import com.landlord.dto.EstateDTO;
import com.landlord.dto.UserDTO;
import com.landlord.models.ChatMessage;
import com.landlord.models.User;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.base.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
//@Scope("prototype")
public class ChatMessageMapperImpl implements DTOMapper<ChatMessage, ChatMessageDTO> {
    private final UserMapperImpl userMapper;
    //private final EstateMapperImpl estateMapper;

    @Autowired()
    public ChatMessageMapperImpl(
            UserMapperImpl userMapper//,
    //        EstateMapperImpl estateMapper
    ) {
        this.userMapper = userMapper;
    //    this.estateMapper = estateMapper;
    }

    @Override
    public ChatMessageDTO map(ChatMessage model) {
        ChatMessageDTO dtoModel = new ChatMessageDTO();
        dtoModel.id=model.getId();
        dtoModel.message=model.getMessage();
        dtoModel.date=model.getDate();
        //dtoModel.estate=estateMapper.map(model.getEstate());
        dtoModel.sender=userMapper.map(model.getSender());
        return dtoModel;
    }

    @Override
    public ChatMessage map(ChatMessageDTO dtoModel) {
        ChatMessage model = new ChatMessage();
        model.setId(dtoModel.id);
        model.setMessage(dtoModel.message);
        model.setDate(dtoModel.date);
        //model.setEstate(estateMapper.map(dtoModel.estate));
        model.setSender(userMapper.map(dtoModel.sender));
        return model;
    }

    @Override
    public List<ChatMessageDTO> mapMany(List<ChatMessage> models) {
        return models.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }
    @Override
    public List<ChatMessage> mapManyToModel(List<ChatMessageDTO> dtoModels) {
        return dtoModels.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}

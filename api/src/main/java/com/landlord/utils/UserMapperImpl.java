package com.landlord.utils;

import com.landlord.dto.UserDTO;
import com.landlord.models.User;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.base.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl  implements DTOMapper<User, UserDTO> {
//    private final EstateMapperImpl estateMapper;
//    private final ChatMessageMapperImpl chatMessageMapper;
//
//    @Autowired
//    public UserMapperImpl(
//            EstateMapperImpl estateMapper,
//            ChatMessageMapperImpl chatMessageMapper
//    ) {
//        this.estateMapper = estateMapper;
//        this.chatMessageMapper = chatMessageMapper;
//    }

    @Override
    public UserDTO map(User model) {
        UserDTO dtoModel = new UserDTO();
        dtoModel.id = model.getId();
        dtoModel.userName=model.getUserName();
        dtoModel.rating = model.getRating();
        dtoModel.userType = model.getUserType();
        //dtoModel.estates = estateMapper.mapMany(model.getEstates());
        //dtoModel.messages = chatMessageMapper.mapMany(model.getMessages());
        return dtoModel;
    }

    @Override
    public User map(UserDTO dtoModel) {
        User model = new User();
        model.setId(dtoModel.id);
        model.setUserName(dtoModel.userName);
        model.setRating(dtoModel.rating);
        model.setUserType(dtoModel.userType);
        //model.setEstates(estateMapper.mapManyToModel(dtoModel.getEstates()));
        //model.setMessages(chatMessageMapper.mapManyToModel(dtoModel.getMessages()));
        return model;
    }

    @Override
    public List<UserDTO> mapMany(List<User> models) {
        return models.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }

    @Override
    public List<User> mapManyToModel(List<UserDTO> dtoModels) {
        return dtoModels.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}

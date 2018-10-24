package com.landlord.utils;

import com.landlord.dto.UserDTO;
import com.landlord.models.User;
import com.landlord.utils.base.DTOMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl  implements DTOMapper<User, UserDTO> {


    @Override
    public UserDTO map(User model) {
        UserDTO dtoModel = new UserDTO();
        dtoModel.id = model.getId();
        dtoModel.userName=model.getUserName();
        dtoModel.rating = model.getRating();
        dtoModel.userType = model.getUserType();
       // dtoModel.estates = model.getEstates();
       // dtoModel.messages = model.getMessages();
        return dtoModel;
    }

    @Override
    public User map(UserDTO dtoModel) {
        User model = new User();
        model.setId(dtoModel.id);
        model.setUserName(dtoModel.userName);
        model.setRating(dtoModel.rating);
        model.setUserType(dtoModel.userType);
        //model.setEstates(dtoModel.estates);
       // model.setMessages(dtoModel.messages);
        return model;
    }

    @Override
    public List<UserDTO> mapMany(List<User> models) {
        return models.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }
}

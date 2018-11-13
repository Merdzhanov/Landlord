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
        dtoModel.firstName=model.getFirstName();
        dtoModel.lastName=model.getLastName();
        dtoModel.rating = model.getRating();
        dtoModel.userType = model.getUserType();
        return dtoModel;
    }

    @Override
    public User map(UserDTO dtoModel) {
        User model = new User();
        model.setId(dtoModel.id);
        model.setUserName(dtoModel.userName);
        model.setFirstName(dtoModel.firstName);
        model.setLastName(dtoModel.lastName);
        model.setRating(dtoModel.rating);
        model.setUserType(dtoModel.userType);
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

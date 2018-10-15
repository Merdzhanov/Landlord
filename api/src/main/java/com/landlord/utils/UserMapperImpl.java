package com.landlord.utils;

import com.landlord.models.User;
import com.landlord.utils.base.UserMapper;
import com.landlord.viewmodels.UserDetailsViewModel;
import com.landlord.viewmodels.UserViewModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserViewModel map(User model) {
        UserViewModel vm = new UserViewModel();
        vm.estates=model.getEstates();
        vm.rating=model.getRating();
        vm.userName=model.getId();
        vm.userType=model.getUserType();

        return vm;
    }

    @Override
    public User map(UserViewModel viewModel) {
        User model = new User();
        model.setEstates(viewModel.estates);
        model.setRating(viewModel.rating);
        model.setId(viewModel.userName);
        model.setUserType(viewModel.userType);
        return model;
    }

    @Override
    public List<UserViewModel> mapMany(List<User> models) {
        return models.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }

    @Override
    public UserDetailsViewModel mapDetails(User model) {
        UserDetailsViewModel vm = new UserDetailsViewModel();
        vm.estates = model.getEstates();
        vm.rating = model.getRating();
        vm.userName = model.getId();
        vm.userType=model.getUserType();
        return vm;
    }
}

package com.landlord.utils.base;

import com.landlord.models.User;
import com.landlord.viewmodels.UserDetailsViewModel;
import com.landlord.viewmodels.UserViewModel;

import java.util.List;

public interface UserMapper {
    UserViewModel map(User model);

    User map(UserViewModel viewModel);

    List<UserViewModel> mapMany(List<User> models);

    UserDetailsViewModel mapDetails(User model);
}

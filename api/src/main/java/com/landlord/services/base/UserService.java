package com.landlord.services.base;

import com.landlord.dto.UserDTO;
import com.landlord.models.User;

public interface UserService {
//        List<User> getAllUsers();
        User getByUserName(String userName);

        UserDTO getDTOByUserName(String userName);
}

package com.landlord.repositories.base;

import com.landlord.models.User;
import java.util.List;

public interface UsersRepository{
//    List<User> getAllUsers();
    User getByUserName(String userName);
}

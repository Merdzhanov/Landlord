package com.landlord.repositories.base;

import com.landlord.models.User;

public interface UsersRepository{
    User getByUserName(String userName);
}

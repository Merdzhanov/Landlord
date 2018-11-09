package com.landlord.android.services;

import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.User;
import com.landlord.android.models.base.UserType;
import com.landlord.android.repositories.base.Repository;

import com.landlord.android.services.base.UsersService;

import java.io.IOException;
import java.util.List;


public class HttpUsersService implements UsersService {
    private final Repository<User> mUsersRepository;

    public HttpUsersService(Repository<User> UsersRepository) {
        this.mUsersRepository = UsersRepository;
    }
    @Override
    public List<User> getAllUsers() throws IOException {
        return mUsersRepository.getAllUsers();
    }

    @Override
    public List<User> getUsersByType(UserType userType) throws IOException {
        return mUsersRepository.getUsersByType(userType);
    }

    @Override
    public User getUserByUsername(String username) throws IOException {
        return mUsersRepository.getUserByUsername(username);
    }
}

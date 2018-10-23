package com.landlord.services;

import com.landlord.models.User;
import com.landlord.models.base.UserType;
import com.landlord.repositories.UserSqlRepositoryImpl;
import com.landlord.services.base.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements GenericService<User> {

    private final UserSqlRepositoryImpl userRepository;

    @Autowired
    public UserServiceImpl(UserSqlRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    @Override
    public User getById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void update(int id, User user) {
        userRepository.update(id, user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    public List getByType (UserType type) {
        return this.userRepository.getByType(type);
    }
}

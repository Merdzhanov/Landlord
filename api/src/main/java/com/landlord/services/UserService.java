package com.landlord.services;

import com.landlord.models.User;
import com.landlord.repositories.UserSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserSqlRepository userRepository;

    @Autowired
    public UserService(UserSqlRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.getAll();
    }

    public List<User> getByType (String type) {
        return this.userRepository.getByType(type);
    }

    public User getUserById(int id) {
        return this.userRepository.getById(id);
    }

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(int id, User user) {
        userRepository.update(id, user);
    }
    
    public void delete(int id) {
        userRepository.delete(id);
    }
}

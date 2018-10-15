package com.landlord.services;

import com.landlord.models.User;
import com.landlord.repositories.base.GenericRepository;
import com.landlord.services.base.LandlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordServiceImpl implements LandlordService {

    private final GenericRepository<User> userRepository;

    @Autowired
    public LandlordServiceImpl(GenericRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User create(User user) {
        userRepository.add(user);
        return user;
    }
}

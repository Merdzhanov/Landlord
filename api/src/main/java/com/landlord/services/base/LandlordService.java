package com.landlord.services.base;

import com.landlord.models.User;

import java.util.List;

public interface LandlordService {
    List<User> getAll();

    User findById(String id);

    User create(User user);
}

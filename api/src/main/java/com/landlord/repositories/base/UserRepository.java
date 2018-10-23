package com.landlord.repositories.base;

import com.landlord.models.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

    User getById(int id);

    List<User> getByType(String type);

    void update(int id, User user);

    void delete(int id);

    void create(User user);

}

package com.landlord.repositories.base;

import com.landlord.models.User;
import com.landlord.models.base.UserType;

import java.util.List;

public interface UserRepository {

    List getAll();

    User getById(int id);

    List getByType(UserType type);

    void update(int id, User user);

    void delete(int id);

    void create(User user);

}

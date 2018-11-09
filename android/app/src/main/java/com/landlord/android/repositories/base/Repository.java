package com.landlord.android.repositories.base;

import com.landlord.android.models.Estate;
import com.landlord.android.models.base.UserType;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    List<T> getAll() throws IOException;

    List<T> getEstatesByUser(String userName) throws IOException;

    T getEstateByID(int estateID) throws IOException;

    T add(T item) throws IOException;

    T getById(int id) throws IOException;

    List<T> getMessagesByEstate(String estateName) throws IOException;;

    List<T> getMessagesByEstateID(Integer mEstateId) throws IOException;

    T getUserByUsername(String username) throws IOException;

    List<T> getUsersByType(UserType userType);

    List<T> getAllUsers();
}

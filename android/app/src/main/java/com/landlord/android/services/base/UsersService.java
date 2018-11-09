package com.landlord.android.services.base;

import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.User;
import com.landlord.android.models.base.UserType;

import java.io.IOException;
import java.util.List;

public interface UsersService {

    List<User> getAllUsers() throws IOException;

    List<User> getUsersByType(UserType userType) throws IOException;

    User getUserByUsername(String username) throws IOException;
}

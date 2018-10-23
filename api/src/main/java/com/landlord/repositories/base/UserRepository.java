package com.landlord.repositories.base;

import com.landlord.models.User;
import com.landlord.models.base.UserType;

import java.util.List;

public interface UserRepository  {

    List getByType(UserType type);


}

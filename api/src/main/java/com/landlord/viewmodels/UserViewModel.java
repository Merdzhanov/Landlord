package com.landlord.viewmodels;

import com.landlord.models.Estate;
import com.landlord.models.base.UserType;

import java.util.List;

public class UserViewModel {
    public String userName;
    public Double rating;
    public UserType userType;
    public List<Estate> estates;
}

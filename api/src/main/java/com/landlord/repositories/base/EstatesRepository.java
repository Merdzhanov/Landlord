package com.landlord.repositories.base;

import com.landlord.models.Estate;

import java.util.List;

public interface EstatesRepository{
    List<Estate> getEstatesByUser(String userName);
    Estate getEstateByID(int id);
}

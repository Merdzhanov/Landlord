package com.landlord.repositories.base;


import com.landlord.models.base.ModelBase;

import java.util.List;

public interface GenericRepository<T extends ModelBase> {
    List<T> findAll();

    T findById(String id);

    void add(T user);
}

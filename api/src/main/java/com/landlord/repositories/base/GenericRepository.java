package com.landlord.repositories.base;

import com.landlord.models.base.ModelBase;

import java.util.List;

public interface GenericRepository<T extends ModelBase> {
    void create(T item);
    //T getById(int id);
    void update(int id, T item);
    void delete(int id);
}

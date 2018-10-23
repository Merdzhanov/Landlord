package com.landlord.repositories.base;

import java.util.List;

public interface GenericRepository<T> {

    List getAll();

    T getById(int id);

    void delete(int id);

    void update(int id, T item);

    void create(T item);


}

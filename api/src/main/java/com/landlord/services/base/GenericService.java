package com.landlord.services.base;

import java.util.List;

public interface GenericService<T> {

    List<T> getAll();

    T getById(int id);

    void create(T item);

    void update (int id, T item);

    void delete (int id);

}

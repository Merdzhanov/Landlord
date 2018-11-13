package com.landlord.services.base;

import com.landlord.models.base.ModelBase;

public interface GenericService<T extends ModelBase> {
        void create(T item);
        void update(int id, T item);
        void delete(T item);
}

package com.landlord.repositories;

import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class InMemoryRepositoryImpl<T extends ModelBase> implements GenericRepository<T> {
    private final Class<T> klass;
    private List<T> items;

    @Autowired
    public InMemoryRepositoryImpl(Class<T> klass) {
        this.klass = klass;
        this.items = new ArrayList<>();
    }

    @Override
    public List<T> findAll() {
        return this.items;
    }


    @Override
    public T findById(String id) {
        return this.items.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(T user) {
        if(user.getId().isEmpty()) {
            String nextId = this.getNextId();
            user.setId(nextId);
        }
        this.items.add(user);
    }

    private String getNextId() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }
}

//        int biggestId = this.items.stream()
//            .mapToIn(ModelBase::getId)
//            .max()
//            .orElse(0);
//        return biggestId + 1;
//    }


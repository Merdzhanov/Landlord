package com.landlord.services;

import com.landlord.models.base.ModelBase;
import com.landlord.repositories.base.GenericRepository;
import com.landlord.services.base.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericServiceImpl<T> implements GenericService {

    private final GenericRepository<ModelBase> mGenericRepository;

    @Autowired
    public GenericServiceImpl(GenericRepository<ModelBase> genericRepository) {
        this.mGenericRepository = genericRepository;
    }

    @Override
    public void create(ModelBase item) {
          mGenericRepository.create(item);
    }

//    @Override
//    public ModelBase getById(int id) {
//        return mGenericRepository.getById(id);
//    }

    @Override
    public void update(int id, ModelBase item) {
        mGenericRepository.update(id, item);
    }

    @Override
    public void delete(int id) {
        mGenericRepository.delete(id);
    }
}

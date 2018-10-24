package com.landlord.services;

import com.landlord.models.Estate;
import com.landlord.repositories.EstateSqlRepositoryImpl;
import com.landlord.repositories.base.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateServiceImpl implements GenericRepository<Estate> {

        private final EstateSqlRepositoryImpl estateRepository;

        @Autowired
        public EstateServiceImpl(EstateSqlRepositoryImpl estateRepository) {
            this.estateRepository = estateRepository;
        }

        @Override
        public List getAll() {
            return this.estateRepository.getAll();
        }

        @Override
        public Estate getById(int id) {
            return this.estateRepository.getById(id);
        }

        @Override
        public void create(Estate estate) {
            estateRepository.create(estate);
        }

        @Override
        public void update(int id, Estate estate) {
            estateRepository.update(id, estate);
        }

        @Override
        public void delete(int id) {
            estateRepository.delete(id);
        }

        public List getEstateByUser(String userName){
            return this.estateRepository.getEstatesByUser(userName);
        }

}

package com.landlord.android.services;


import com.landlord.android.models.Estate;
import com.landlord.android.models.EstateDTO;
import com.landlord.android.repositories.base.Repository;
import com.landlord.android.services.base.EstatesDTOService;

import java.io.IOException;

public class HttpEstatesDTOService implements EstatesDTOService {
    private final Repository<EstateDTO> mEstatesRepository;

    public HttpEstatesDTOService(Repository<EstateDTO> EstateRepository) {
        mEstatesRepository = EstateRepository;
    }

//    @Override
//    public List<Estate> getAllEstates() throws IOException {
//        return mEstatesRepository.getAll();
//    }
//
//    @Override
//    public List<Estate> getEstatesByUser(String userName) throws IOException {
//        return mEstatesRepository.getEstatesByUser(userName);
//    }
//
//    @Override
//    public Estate getDetailsById(int id) throws IOException {
//        return mEstatesRepository.getEstateByID(id);
//    }
//
//    @Override
//    public List<Estate> getFilteredEstates(String pattern) throws IOException {
//        return null;
//    }
//
//    @Override
//    public List<Estate> getFilteredEstates(String pattern,String userName) throws IOException {
//        String patternToLower = pattern.toLowerCase();
//
//        return  getEstatesByUser(userName) .stream()
//                .filter(Estate -> Estate.getName().toLowerCase().contains(patternToLower))
//                .collect(Collectors.toList());
//    }

    @Override
    public EstateDTO createEstate(Estate estate) throws IOException {
        EstateDTO estateDTO=new EstateDTO();
        estateDTO.setId(estate.getId());
        estateDTO.setImage(estate.getImage());
        estateDTO.setMonthlyRent(estate.getMonthlyRent());
        return mEstatesRepository.add(estateDTO);
    }

    @Override
    public EstateDTO updateEstate(Estate estate) throws IOException {
        EstateDTO estateDTO=new EstateDTO();
        estateDTO.setId(estate.getId());
        estateDTO.setImage(estate.getImage());
        estateDTO.setMonthlyRent(estate.getMonthlyRent());
        return mEstatesRepository.update(estateDTO);
    }

}

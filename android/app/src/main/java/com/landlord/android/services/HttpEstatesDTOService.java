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

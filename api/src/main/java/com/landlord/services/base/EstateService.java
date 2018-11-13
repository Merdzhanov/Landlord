package com.landlord.services.base;

import com.landlord.dto.EstateDTO;
import com.landlord.models.Estate;

import java.util.List;

public interface EstateService {
        List<EstateDTO> getEstatesByUser(String userName);
        EstateDTO getEstateByID(int id);
        void updateEstate(Estate estateInput);
}

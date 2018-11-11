package com.landlord.android.services.base;


import com.landlord.android.models.Estate;
import com.landlord.android.models.EstateDTO;

import java.io.IOException;

public interface EstatesDTOService {
//    List<Estate> getAllEstates() throws IOException;
//
//    List<Estate> getEstatesByUser(String userName) throws IOException;
//
//    Estate getDetailsById(int id) throws IOException;
//
//    List<Estate> getFilteredEstates(String pattern) throws IOException;
//
//    List<Estate> getFilteredEstates(String pattern, String userName) throws IOException;

    EstateDTO createEstate(Estate Estate) throws IOException;

    EstateDTO updateEstate(Estate mEstate) throws IOException;
}

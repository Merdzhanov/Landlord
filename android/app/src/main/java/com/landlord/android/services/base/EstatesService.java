package com.landlord.android.services.base;


import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.Estate;

import java.io.IOException;
import java.util.List;

public interface EstatesService {
    List<Estate> getAllEstates() throws IOException;

    List<Estate> getEstatesByUser(String userName) throws IOException;

    Estate getDetailsById(int id) throws IOException;

    List<Estate> getFilteredEstates(String pattern) throws IOException;

    Estate createEstate(Estate Estate) throws IOException;

}

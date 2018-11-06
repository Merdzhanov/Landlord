package com.landlord.android.services;


import com.landlord.android.models.ChatMessage;
import com.landlord.android.models.Estate;
import com.landlord.android.repositories.base.Repository;
import com.landlord.android.services.base.EstatesService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HttpEstatesService implements EstatesService {
    private final Repository<Estate> mEstatesRepository;

    public HttpEstatesService(Repository<Estate> EstateRepository) {
        mEstatesRepository = EstateRepository;
    }

    @Override
    public List<Estate> getAllEstates() throws IOException {
        return mEstatesRepository.getAll();
    }

    @Override
    public List<Estate> getEstatesByUser(String userName) throws IOException {
        return mEstatesRepository.getEstatesByUser(userName);
    }

    @Override
    public Estate getDetailsById(int id) throws IOException {
        return mEstatesRepository.getEstateByID(id);
    }

    @Override
    public List<Estate> getFilteredEstates(String pattern) throws IOException {
        String patternToLower = pattern.toLowerCase();

        return getAllEstates().stream()
                .filter(Estate -> Estate.getName().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }

    @Override
    public Estate createEstate(Estate Estate) throws IOException {
        return mEstatesRepository.add(Estate);
    }

}

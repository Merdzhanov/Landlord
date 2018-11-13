package com.landlord.services;

import com.landlord.dto.EstateDTO;
import com.landlord.models.Estate;
import com.landlord.repositories.base.EstatesRepository;
import com.landlord.services.base.EstateService;
import com.landlord.services.base.GenericService;
import com.landlord.utils.EstateMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateServiceImpl implements EstateService {

    private final EstatesRepository mEstatesRepository;
    private final EstateMapperImpl mEstateMapper;
    private final GenericService<Estate> mGenericService;
   // private final GenericRepository<RatingVote> mGenericRepository;
    // private final UserMapperImpl userMapper;

    @Autowired
    public EstateServiceImpl(
            EstatesRepository estatesRepository,
            EstateMapperImpl estateMapper,
            GenericService<Estate> genericService
            )
    {
        mEstatesRepository = estatesRepository;
        mEstateMapper = estateMapper;
        mGenericService = genericService;
    }

    @Override
    public List<EstateDTO> getEstatesByUser(String userName) {
        return mEstateMapper.mapMany(mEstatesRepository.getEstatesByUser(userName));
    }

    @Override
    public EstateDTO getEstateByID(int id) {
            return mEstateMapper.map(mEstatesRepository.getEstateByID(id));
    }

    @Override
    public void updateEstate(Estate estateInput) {
        int id=estateInput.getId();
        EstateDTO estateDTO = getEstateByID(id);
        Estate estate = mEstateMapper.map(estateDTO);
        estate.setImage(estateInput.getImage());
        mGenericService.update(id,estate);
    }

    //    @Override
//    public List<Estate> getAllEstates() {
//        return mEstatesRepository.getAllEstates();
//    }

}

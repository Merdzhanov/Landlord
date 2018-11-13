package com.landlord.api;

import com.landlord.dto.*;
import com.landlord.models.Estate;
import com.landlord.services.base.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class EstatesApiController {
    private final EstateService mEstateService;

    @Autowired
    public EstatesApiController(
            EstateService estateService
    ) {
        mEstateService = estateService;
    }

    @RequestMapping(
            value = "Estates/User/{userName}",
            method = RequestMethod.GET
    )
    public List<EstateDTO> getEstatesByUser(@PathVariable("userName") String userName) {
        return mEstateService.getEstatesByUser(userName);
    }

    @RequestMapping(
            value = "Estates/ID/{id}",
            method = RequestMethod.GET
    )
    public EstateDTO getEstatesByID(@PathVariable("id") int id) {
        return mEstateService.getEstateByID(id);
    }

    @RequestMapping(
            value = "Estates/update",
            method = RequestMethod.PUT
    )
    public void updateEstate(@RequestBody Estate estateInput) {
        mEstateService.updateEstate(estateInput);
    }
}

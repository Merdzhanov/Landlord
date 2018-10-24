package com.landlord.api;


import com.landlord.dto.UserDTO;
import com.landlord.models.Estate;
import com.landlord.models.User;
import com.landlord.models.base.ModelBase;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.UserMapperImpl;
import com.landlord.utils.base.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class LandlordApiController {
    private final LandlordService landlordService;
    private final UserMapperImpl userMapper;

    @Autowired
    public LandlordApiController(LandlordService landlordService, UserMapperImpl userMapper) {
        this.landlordService = landlordService;
        this.userMapper = userMapper;
    }

    @RequestMapping(
            path="Users",
        method = RequestMethod.GET
    )
    public List<UserDTO> getAllUsers() {
        List<User> models = this.landlordService.getAllUsers();
        return this.userMapper.mapMany(models);
    }
    @RequestMapping(
            path="Estates",
            method = RequestMethod.GET
    )
    public List<Estate> getAllEstates() {
        List<Estate> models = this.landlordService.getAllEstates();
        return models;//this.userMapper.mapMany(models);
    }

    @RequestMapping(
        value = "Estates/User/{userName}",
        method = RequestMethod.GET
    )
    public List<Estate> getEstatesByUser(@PathVariable("userName") String userName) {
        List<Estate> estates = this.landlordService.getEstatesByUser(userName);
        return estates;//his.userMapper.map(model);
    }
    @RequestMapping(
            value = "Estates/ID/{id}",
            method = RequestMethod.GET
    )
    public Estate getEstatesByID(@PathVariable("id") int id) {
        Estate estate = this.landlordService.getEstateByID(id);
        return estate;//his.userMapper.map(model);
    }

//    @RequestMapping(
//        method = RequestMethod.POST
//    )
//    public ResponseEntity<UserViewModel> createUser(@RequestBody UserViewModel userVm) {
//        User model = this.mapper.map(userVm);
//        User user = this.landlordService.create(model);
//        UserViewModel vmToReturn = this.mapper.map(user);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//            .body(vmToReturn);
//    }
}

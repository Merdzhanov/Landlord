package com.landlord.api;


import com.landlord.dto.EstateDTO;
import com.landlord.dto.UserDTO;
import com.landlord.models.Estate;
import com.landlord.models.User;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.ChatMessageMapperImpl;
import com.landlord.utils.EstateMapperImpl;
import com.landlord.utils.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class LandlordApiController {
    private final LandlordService landlordService;
    private final UserMapperImpl userMapper;
    private final EstateMapperImpl estateMapper;
    private final ChatMessageMapperImpl chatMessageMapper;


    @Autowired
    public LandlordApiController(
            LandlordService landlordService,
            UserMapperImpl userMapper,
            EstateMapperImpl estateMapper,
            ChatMessageMapperImpl chatMessageMapper
    ) {
        this.landlordService = landlordService;
        this.userMapper = userMapper;
        this.estateMapper = estateMapper;
        this.chatMessageMapper = chatMessageMapper;
    }

    @RequestMapping(
            path = "Users",
            method = RequestMethod.GET
    )
    public List<UserDTO> getAllUsers() {
        List<User> models = this.landlordService.getAllUsers();
        return this.userMapper.mapMany(models);
    }

    @RequestMapping(
            path = "Estates",
            method = RequestMethod.GET
    )
    public List<EstateDTO> getAllEstates() {
        List<Estate> models = this.landlordService.getAllEstates();
        return this.estateMapper.mapMany(models);
    }

    @RequestMapping(
            value = "Estates/User/{userName}",
            method = RequestMethod.GET
    )
    public List<EstateDTO> getEstatesByUser(@PathVariable("userName") String userName) {
        List<Estate> models = this.landlordService.getEstatesByUser(userName);
        return this.estateMapper.mapMany(models);
    }

    @RequestMapping(
            value = "Estates/ID/{id}",
            method = RequestMethod.GET
    )
    public EstateDTO getEstatesByID(@PathVariable("id") int id) {
        Estate estate = this.landlordService.getEstateByID(id);
        return this.estateMapper.map(estate);
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

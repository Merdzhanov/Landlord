package com.landlord.api;


import com.landlord.models.User;
import com.landlord.services.base.LandlordService;
import com.landlord.utils.base.UserMapper;
import com.landlord.viewmodels.UserDetailsViewModel;
import com.landlord.viewmodels.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Users")
public class LandlordApiController {
    private final LandlordService landlordService;
    private final UserMapper mapper;

    @Autowired
    public LandlordApiController(LandlordService landlordService, UserMapper mapper) {
        this.landlordService = landlordService;
        this.mapper = mapper;
    }

    @RequestMapping(
        method = RequestMethod.GET
    )
    public List<UserViewModel> getAllUsers() {
        List<User> models = this.landlordService.getAll();
        return this.mapper.mapMany(models);
    }

    @RequestMapping(
        value = "/{id}",
        method = RequestMethod.GET
    )
    public UserDetailsViewModel getUserById(@PathVariable("id") String idString) {
        String id = idString;
        User model = this.landlordService.findById(id);
        return this.mapper.mapDetails(model);
    }

    @RequestMapping(
        method = RequestMethod.POST
    )
    public ResponseEntity<UserViewModel> createUser(@RequestBody UserViewModel userVm) {
        User model = this.mapper.map(userVm);
        User user = this.landlordService.create(model);
        UserViewModel vmToReturn = this.mapper.map(user);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(vmToReturn);
    }
}

package com.landlord.api;


import com.landlord.dto.*;
import com.landlord.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UsersApiController {
    private final UserService mUserService;

    @Autowired
    public UsersApiController(
            UserService userService
    ) {
        mUserService = userService;
    }

    @RequestMapping(
            path = "/Users/Username/{userName}",
            method = RequestMethod.GET
    )
    public UserDTO getUserByUsername(@PathVariable("userName") String userName) {
        return mUserService.getDTOByUserName(userName);
    }
}

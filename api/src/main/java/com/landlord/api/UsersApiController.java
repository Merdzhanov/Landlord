package com.landlord.api;


import com.landlord.dto.*;
import com.landlord.models.User;
import com.landlord.services.base.EstateService;
import com.landlord.services.base.UserService;
import com.landlord.utils.ChatMessageInputMapperImpl;
import com.landlord.utils.ChatMessageMapperImpl;
import com.landlord.utils.EstateMapperImpl;
import com.landlord.utils.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UsersApiController {
    private final UserService mUserService;

    @Autowired
    public UsersApiController(
            UserService userService
    ) {
mUserService=userService;
    }

    @RequestMapping(
            path = "/Users/Username/{userName}",
            method = RequestMethod.GET
    )
    public UserDTO getUserByUsername(@PathVariable("userName") String userName) {
        return mUserService.getDTOByUserName(userName);
    }

    //    @RequestMapping(
//            path = "Users",
//            method = RequestMethod.GET
//    )
//    public List<UserDTO> getAllUsers() {
//        List<User> models = mUserService.getAllUsers();
//        return this.userMapper.mapMany(models);
//    }
}

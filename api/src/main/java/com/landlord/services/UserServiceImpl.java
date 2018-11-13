package com.landlord.services;

import com.landlord.dto.UserDTO;
import com.landlord.models.User;
import com.landlord.repositories.base.UsersRepository;
import com.landlord.services.base.UserService;
import com.landlord.utils.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository mUsersRepository;
    private final UserMapperImpl mUserMappper;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository,
                          UserMapperImpl userMapper
    ) {
        mUsersRepository = usersRepository;
        mUserMappper = userMapper;
    }

    @Override
    public User getByUserName(String userName) {
        return mUsersRepository.getByUserName(userName);
    }

    @Override
    public UserDTO getDTOByUserName(String userName) {
        return mUserMappper.map(mUsersRepository.getByUserName(userName));
    }
    //    @Override
//    public List<User> getAllUsers() {
//        return this.landlordRepository.getAllUsers();
//    }

}

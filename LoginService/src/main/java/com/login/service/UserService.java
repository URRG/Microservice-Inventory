package com.login.service;


import com.login.dto.UserDto;
import com.login.model.User;

public interface UserService {

    User findByUsername(String username);
    User save (UserDto userDto);

}
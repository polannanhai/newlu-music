package com.newlu.newlumusic.service;

import com.newlu.newlumusic.dto.UserCreateDto;
import com.newlu.newlumusic.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);
}

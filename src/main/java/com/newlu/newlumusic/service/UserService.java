package com.newlu.newlumusic.service;

import com.newlu.newlumusic.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserDto> list();
}

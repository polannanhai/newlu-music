package com.newlu.newlumusic.controller;

import com.newlu.newlumusic.dto.UserCreateDto;
import com.newlu.newlumusic.mapper.UserMapper;
import com.newlu.newlumusic.service.UserService;
import com.newlu.newlumusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    UserMapper userMapper;

    @GetMapping("/")
    List<UserVo> list(){


        return userService.list().stream().map(userMapper::

                toVo).collect(Collectors.toList());
    }

    @PostMapping("/")
    UserVo create(@RequestBody UserCreateDto userCreateDto){
        return userMapper.toVo(userService.create(userCreateDto));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}

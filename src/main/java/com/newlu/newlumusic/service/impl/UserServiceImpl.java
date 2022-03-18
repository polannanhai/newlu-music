package com.newlu.newlumusic.service.impl;

import com.newlu.newlumusic.dto.UserCreateDto;
import com.newlu.newlumusic.dto.UserDto;
import com.newlu.newlumusic.entity.User;
import com.newlu.newlumusic.exception.BizException;
import com.newlu.newlumusic.exception.ExceptionType;
import com.newlu.newlumusic.mapper.UserMapper;
import com.newlu.newlumusic.repository.UserRepository;
import com.newlu.newlumusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    UserRepository repository;

    UserMapper mapper;

    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        checkUserName(userCreateDto.getUsername());
        User user= mapper.createEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(user));
    }

    /**
     * 校验username 唯一性
     * @param username
     */
    private void checkUserName(String username){
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()){
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }
}

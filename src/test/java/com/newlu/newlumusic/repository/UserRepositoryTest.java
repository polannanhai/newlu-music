package com.newlu.newlumusic.repository;

import com.newlu.newlumusic.entity.User;
import com.newlu.newlumusic.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("刘路");
        user.setNickname("学习者刘路");
        user.setPassword("123456");
        user.setLocked(false);
        user.setEnabled(true);
        user.setGender(Gender.MALE);
        user.setLastLoginIp("127.0.0.1");
        user.setLastLoginTime(new Date());

        User savedUser = repository.save(user);

        User result = repository.getByUsername("刘路");
        System.out.println(result.toString());
    }


}
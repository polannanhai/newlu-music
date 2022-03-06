package com.newlu.newlumusic.repository;

import com.newlu.newlumusic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    User getByUsername(String username);
}
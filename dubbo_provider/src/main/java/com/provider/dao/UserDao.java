package com.provider.dao;

import com.provider.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<UserEntity> getAllUser();

    void addUser(UserEntity userEntity);

    UserEntity getUserById(Integer id);

    void updateUser(UserEntity userEntity);

    void deleteUserById(Integer id);
}
package com.api.service;

import com.api.model.UserModel;

import java.util.List;

public interface UserService {

    String test();

    List<UserModel> getAllUser();

    void addUser(UserModel userModel);

    UserModel getUserById(Integer id);

    void updateUser(UserModel userModel);

    void deleteUser(Integer[] ids);
}
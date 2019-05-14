package com.provider.serviceImpl;

import com.api.model.UserModel;
import com.api.service.UserService;
import com.provider.dao.UserDao;
import com.provider.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String test() {
        return "Hello Dubbo!";
    }

    @Override
    public List<UserModel> getAllUser() {
        List<UserEntity> userEntityList = userDao.getAllUser();
        List<UserModel> userModelList = new ArrayList<>();
        for (UserEntity userEntity : userEntityList) {
            UserModel userModel = new UserModel();
            userModel.setName(userEntity.getName());
            userModel.setId(userEntity.getId());
            userModel.setAge(userEntity.getAge());
            userModelList.add(userModel);
        }
        return userModelList;
    }

    @Override
    public void addUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userModel.getName());
        userEntity.setAge(userModel.getAge());
        userEntity.setPassword(userModel.getPassword());
        userDao.addUser(userEntity);
    }

    @Override
    public UserModel getUserById(Integer id) {
        UserEntity userEntity = userDao.getUserById(id);
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        userModel.setAge(userEntity.getAge());
        userModel.setPassword(userEntity.getPassword());
        return userModel;
    }

    @Override
    public void updateUser(UserModel userModel) {
        UserEntity userEntity = userDao.getUserById(userModel.getId());
        userEntity.setName(userModel.getName());
        userEntity.setAge(userModel.getAge());
        userEntity.setPassword(userModel.getPassword());
        userDao.updateUser(userEntity);
    }

    @Override
    public void deleteUser(Integer[] ids) {
        for (Integer id : ids) {
            userDao.deleteUserById(id);

        }
    }
}
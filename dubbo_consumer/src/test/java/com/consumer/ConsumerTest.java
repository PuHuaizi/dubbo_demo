package com.consumer;

import com.api.model.UserModel;
import com.api.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.test());
        UserModel userModel = userService.getUserById(1);
        System.out.println(userModel.getId());
        System.out.println(userModel.getName());
        System.out.println(userModel.getAge());
        System.out.println(userModel.getPassword());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
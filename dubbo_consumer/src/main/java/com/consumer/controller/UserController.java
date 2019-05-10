package com.consumer.controller;

import com.api.model.UserModel;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private String Prefix = "user/";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/test")
    public String test() {
        return userService.test();
    }

    @RequestMapping(value = "/getAllUser")
    public String getAllUser(ModelMap modelMap) {
        modelMap.put("userModelList", userService.getAllUser());
        return Prefix + "user_list";
    }

    @RequestMapping(value = "/getUserDetailForm")
    public String getUserDetailForm(ModelMap modelMap, Integer id) {
        if (id != null) {
            modelMap.put("userModel", userService.getUserById(id));
        }
        return Prefix + "user_detail";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(UserModel userModel) {
        userService.addUser(userModel);
        return "redirect:getAllUser";
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser(UserModel userModel) {
        userService.updateUser(userModel);
        return "redirect:getAllUser";
    }

    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestParam(value = "ids[]") Integer[] ids) {
        userService.deleteUser(ids);
        return true;
    }
}

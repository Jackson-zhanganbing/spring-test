package com.zab.springboot.project.controller;

import com.zab.springboot.common.ResponseVo;
import com.zab.springboot.project.domain.User;
import com.zab.springboot.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * user controller
 *
 * @author zab
 * @date 2021/12/13 10:28 PM
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public ResponseVo<List<User>> getUsers(){
        return userService.getUsers();
    }
}

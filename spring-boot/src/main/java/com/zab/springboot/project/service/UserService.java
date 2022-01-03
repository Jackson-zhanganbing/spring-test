package com.zab.springboot.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zab.springboot.common.ResponseVo;
import com.zab.springboot.project.domain.User;

import java.util.List;

/**
* @author zhanganbing
* @description 针对表【user】的数据库操作Service
* @date 2021-12-13 22:19:51
*/
public interface UserService extends IService<User> {

    ResponseVo<List<User>> getUsers();

}

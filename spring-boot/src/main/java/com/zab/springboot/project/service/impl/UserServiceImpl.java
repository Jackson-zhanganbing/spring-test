package com.zab.springboot.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zab.springboot.common.ResponseVo;
import com.zab.springboot.project.domain.User;
import com.zab.springboot.project.mapper.UserMapper;
import com.zab.springboot.project.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zhanganbing
* @description 针对表【user】的数据库操作Service实现
* @createDate 2021-12-13 22:19:51
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Override
    public ResponseVo<List<User>> getUsers() {
        return ResponseVo.<List<User>>success(list());
    }
}





package com.system.yyn.topicsystem.service.impl;

import com.system.yyn.topicsystem.entity.po.User;
import com.system.yyn.topicsystem.mapper.UserMapper;
import com.system.yyn.topicsystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : lyj
 * @description:
 * @date :2020/3/22  8:38
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public int regist(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public User findUser(User user) {
        return userMapper.findUser(user);
    }


}

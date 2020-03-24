package com.system.yyn.topicsystem.service.impl;

import com.system.yyn.topicsystem.entity.po.User;
import com.system.yyn.topicsystem.mapper.UserMapper;
import com.system.yyn.topicsystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 用户信息维护接口
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

    @Override
    public int updateUser(User user) {
        int update = userMapper.update(user);
        return update;
    }

    @Override
    public User getUserInfo(User user) {
        User userInfo = userMapper.getUserInfo(user);
        return userInfo;
    }

    @Override
    public List<User> getUserList(User user) {
        List<User> userList = userMapper.getUserByUserType(user.getUserType());
        return userList;
    }

}

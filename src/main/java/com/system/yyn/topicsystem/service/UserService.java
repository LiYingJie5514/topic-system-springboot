package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.entity.po.User;

import java.util.List;

public interface UserService {

    /**
     * 注册 添加用户信息
     * @param user
     * @return
     */
    int regist(User user);

    /**
     * 登录判断
     * @param user
     * @return
     */
    User findUser(User user);

    /**
     * 信息修改
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    User getUserInfo(User user);

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    List<User> getUserList(User user);

}

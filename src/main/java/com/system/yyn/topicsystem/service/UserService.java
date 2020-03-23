package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.entity.po.User;

public interface UserService {

    /**
     * 注册
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

}

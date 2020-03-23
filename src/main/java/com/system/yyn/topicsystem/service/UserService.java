package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.entity.po.User;

public interface UserService {


    int regist(User user);

    User findUser(User user);



}

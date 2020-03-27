package com.system.yyn.topicsystem.mapper;

import com.system.yyn.topicsystem.entity.po.User;

import java.util.List;

public interface UserMapper {

    int insert(User user);

    int update(User user);

    int delete(User user);

    List<User> getAll(); // 查询全部

    User findUser(User user);// 用于登陆判断

    List<User> getUserByName(String user);

    User getUserInfo(User user);

    List<User> getUserByUserType(User user);
}

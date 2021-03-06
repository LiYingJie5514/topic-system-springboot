package com.system.yyn.topicsystem.mapper;

import com.system.yyn.topicsystem.entity.po.Bulletin;

import java.util.List;

public interface BulletinMapper {

    int insert(Bulletin bulletin);

    int update(Bulletin bulletin);

    int delete(Bulletin bulletin);

    List<Bulletin> getList();

    Bulletin select(Bulletin bulletin);
}

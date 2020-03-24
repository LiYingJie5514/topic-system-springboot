package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.entity.po.Bulletin;

import java.util.List;

public interface BulletinService {

    int send(Bulletin bulletin);

    int update(Bulletin bulletin);

    int delete(Bulletin bulletin);

    List<Bulletin> getList();

    Bulletin select(Bulletin bulletin);
}

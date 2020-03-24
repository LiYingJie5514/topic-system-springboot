package com.system.yyn.topicsystem.service.impl;

import com.system.yyn.topicsystem.entity.po.Bulletin;
import com.system.yyn.topicsystem.mapper.BulletinMapper;
import com.system.yyn.topicsystem.service.BulletinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName : BulletinServiceImpl
 * @Description :公告
 */
@Service
public class BulletinServiceImpl implements BulletinService {

    @Resource
    private BulletinMapper bulletinMapper;

    @Override
    public int send(Bulletin bulletin) {
        int insert = bulletinMapper.insert(bulletin);
        return insert;
    }

    @Override
    public int update(Bulletin bulletin) {
        int update = bulletinMapper.update(bulletin);
        return update;
    }

    @Override
    public int delete(Bulletin bulletin) {
        int delete = bulletinMapper.delete(bulletin);
        return delete;
    }

    @Override
    public List<Bulletin> getList() {
        List<Bulletin> list = bulletinMapper.getList();
        return list;
    }

    @Override
    public Bulletin select(Bulletin bulletin) {
        Bulletin select = bulletinMapper.select(bulletin);
        return select;
    }

}

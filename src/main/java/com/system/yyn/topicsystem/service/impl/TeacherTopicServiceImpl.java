package com.system.yyn.topicsystem.service.impl;

import com.system.yyn.topicsystem.business.request.AddTopicRequest;
import com.system.yyn.topicsystem.entity.po.TeacherTopic;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.mapper.TeacherTopicMapper;
import com.system.yyn.topicsystem.mapper.TopicMapper;
import com.system.yyn.topicsystem.service.TeacherTopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : lyj
 * @description:
 * @date :2020/3/22  17:24
 */
@Service
public class TeacherTopicServiceImpl implements TeacherTopicService {


    @Resource
    private TopicMapper topicMapper;

    @Resource
    private TeacherTopicMapper teacherTopicMapper;

    @Override
    public int addTopic(AddTopicRequest request) {

        Topic topic = new Topic();
        topic.setTopicTitle(request.getTopicTitle());
        topic.setTopicContent(request.getTopicContent());
        topic.setTopicStatus(0);
        int insert = topicMapper.insert(topic);

        TeacherTopic teacherTopic = new TeacherTopic();
        teacherTopic.setTopicId(topicMapper.getId() + "");
        teacherTopic.setTeacherId(request.getTeacherId());
        int insert1 = teacherTopicMapper.insert(teacherTopic);

        if (insert == insert1 && insert == 1) {
            return 1;
        }

        return 0;
    }


}

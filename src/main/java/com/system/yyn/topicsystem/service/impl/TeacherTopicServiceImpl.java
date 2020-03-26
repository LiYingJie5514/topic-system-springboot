package com.system.yyn.topicsystem.service.impl;

import com.system.yyn.topicsystem.business.request.TeacherAddTopicRequest;
import com.system.yyn.topicsystem.business.request.TeacherGetTopicsRequest;
import com.system.yyn.topicsystem.business.request.TeacherUpdateTopicRequest;
import com.system.yyn.topicsystem.entity.po.TeacherTopic;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.TeacherTopicVO;
import com.system.yyn.topicsystem.mapper.TeacherTopicMapper;
import com.system.yyn.topicsystem.mapper.TopicMapper;
import com.system.yyn.topicsystem.service.TeacherTopicService;
import com.system.yyn.topicsystem.utils.BaseDateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 教师课题接口
 */
@Service
public class TeacherTopicServiceImpl implements TeacherTopicService {

    @Resource
    private TopicMapper topicMapper;

    @Resource
    private TeacherTopicMapper teacherTopicMapper;

    @Override
    public int addTopic(TeacherAddTopicRequest request) {

        Topic topic = new Topic();
        topic.setTopicTitle(request.getTopicTitle());
        topic.setTopicContent(request.getTopicContent());
        topic.setStatus("0");
        topic.setTopicPeriod(BaseDateUtil.getCurDateYYYY());
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

    @Override
    public int updateTopic(TeacherUpdateTopicRequest request) {
        Topic topic = new Topic();
        topic.setTopicId(Long.parseLong(request.getTopicId()));
        topic.setTopicContent(request.getTopicContent());
        topic.setTopicTitle(request.getTopicTitle());
        topic.setStatus(request.getTopicStatus());
        int update = topicMapper.update(topic);
        return update;
    }

    @Override
    public List<TeacherTopicVO> getTopicList(TeacherGetTopicsRequest request) {
        List<TeacherTopicVO> topicList = teacherTopicMapper.getTopicList(request.getTeacherId());
        return topicList;
    }
}

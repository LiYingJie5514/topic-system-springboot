package com.system.yyn.topicsystem.service.impl;

import com.system.yyn.topicsystem.business.response.BaseResponse;
import com.system.yyn.topicsystem.entity.po.StudentTopic;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.mapper.StudentTopicMapper;
import com.system.yyn.topicsystem.mapper.TopicMapper;
import com.system.yyn.topicsystem.service.StudentTopicService;
import com.system.yyn.topicsystem.utils.BaseDateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName : UserTopicServiceImpl
 * @Description : 学生课题接口
 */
@Service
public class StudentTopicServiceImpl implements StudentTopicService {

    @Resource
    private StudentTopicMapper studentTopicMapper;
    @Resource
    private TopicMapper topicMapper;

    @Override
    public BaseResponse selectTopic(String topicId, String studentId) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("0");
        baseResponse.setMessage("选题成功");

        //判断课题状态
        Topic topic = topicMapper.getTopic(topicId);
        if (topic.getTopicStatus() == 0 && topic.getTopicPeriod().equals(BaseDateUtil.getCurDateYYYY())) {
            StudentTopic studentTopic = new StudentTopic();
            studentTopic.setStatus(0);//0选择 1退选
            studentTopic.setStudentId(studentId);
            studentTopic.setTopicId(topicId);
            studentTopicMapper.insert(studentTopic);
        } else {
            baseResponse.setStatus("1");
            baseResponse.setMessage("选题失败，课题信息有误");
        }
        return baseResponse;
    }

    @Override
    public int quitTopic(String topicId, String studentId) {
        StudentTopic studentTopic = new StudentTopic();
        studentTopic.setTopicId(topicId);
        studentTopic.setStudentId(studentId);
        studentTopic.setStatus(1);
        int update = studentTopicMapper.update(studentTopic);
        return update;
    }
}

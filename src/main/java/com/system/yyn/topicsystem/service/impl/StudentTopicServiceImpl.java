package com.system.yyn.topicsystem.service.impl;

import com.system.yyn.topicsystem.business.request.StudentGetTopicsRequest;
import com.system.yyn.topicsystem.business.response.BaseResponse;
import com.system.yyn.topicsystem.entity.dto.StudentGetTopicsDto;
import com.system.yyn.topicsystem.entity.po.StudentTopic;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.StudentTopicVO;
import com.system.yyn.topicsystem.mapper.StudentTopicMapper;
import com.system.yyn.topicsystem.mapper.TopicMapper;
import com.system.yyn.topicsystem.service.StudentTopicService;
import com.system.yyn.topicsystem.utils.BaseDateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public BaseResponse selectTopic(String topicId, String studentId,String reason) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("0");
        baseResponse.setMessage("选题成功");

        //判断课题状态
        Topic topic = topicMapper.getTopic(topicId);
        if (topic.getTopicPeriod().equals(BaseDateUtil.getCurDateYYYY())) {
            StudentTopic studentTopic = new StudentTopic();
            studentTopic.setStatus(0);//0待审核 1审核通过 2审核不通过
            studentTopic.setStudentId(studentId);
            studentTopic.setTopicId(topicId);
            studentTopic.setReason(reason);
            studentTopicMapper.insert(studentTopic);
        } else {
            baseResponse.setStatus("1");
            baseResponse.setMessage("选题失败，课题信息有误");
        }
        return baseResponse;
    }

    @Override
    public int quitTopic(String topicId, String studentId,String reason) {
        StudentTopic studentTopic = new StudentTopic();
        studentTopic.setReason(reason);
        studentTopic.setTopicId(topicId);
        studentTopic.setStudentId(studentId);
        int update = studentTopicMapper.update(studentTopic);
        return update;
    }

    @Override
    public List<StudentTopicVO> getTopics(StudentGetTopicsRequest request) {
        StudentGetTopicsDto studentGetTopicsDto = new StudentGetTopicsDto(request);
        List<StudentTopicVO> list = studentTopicMapper.getList(studentGetTopicsDto);
        return list;
    }
}

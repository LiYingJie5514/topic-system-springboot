package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.business.request.StudentGetTopicsRequest;
import com.system.yyn.topicsystem.business.response.BaseResponse;
import com.system.yyn.topicsystem.entity.vo.StudentTopicVO;

import java.util.List;

public interface StudentTopicService {

    /**
     * 选课题
     *
     * @return
     */
    BaseResponse selectTopic(String topicId, String studentId, String reason);

    /**
     * 退选
     *
     * @param topicId
     * @param studentId
     * @return
     */
    int quitTopic(String topicId, String studentId, String reason);

    /**
     * 获取课题列表
     *
     * @return
     */
    List<StudentTopicVO> getTopics(StudentGetTopicsRequest request);

}

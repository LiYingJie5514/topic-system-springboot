package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.business.request.TeacherAddTopicRequest;
import com.system.yyn.topicsystem.business.request.TeacherGetTopicsRequest;
import com.system.yyn.topicsystem.business.request.TeacherUpdateTopicRequest;
import com.system.yyn.topicsystem.entity.vo.TeacherTopicVO;

import java.util.List;

public interface TeacherTopicService {

    /**
     * 添加课题
     *
     * @param request
     * @return
     */
    int addTopic(TeacherAddTopicRequest request);

    /**
     * 修改课题
     *
     * @param request
     * @return
     */
    int updateTopic(TeacherUpdateTopicRequest request);

    /**
     * 删除课题
     *
     * @param teacherId
     * @param topicId
     * @return
     */
    int delTopic(String teacherId, String topicId);

    /**
     * 课题列表
     *
     * @param request
     * @return
     */
    List<TeacherTopicVO> getTopicList(TeacherGetTopicsRequest request);

}

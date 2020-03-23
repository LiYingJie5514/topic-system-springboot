package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.business.request.AddTopicRequest;
import com.system.yyn.topicsystem.business.request.TeacherGetTopicsRequest;
import com.system.yyn.topicsystem.business.request.TeacherUpdateTopicRequest;
import com.system.yyn.topicsystem.entity.vo.TeacherTopicVO;

import java.util.List;

public interface TeacherTopicService {

    /**
     * 添加课题
     * @param request
     * @return
     */
    int addTopic(AddTopicRequest request);

    /**
     * 修改课题
     * @param request
     * @return
     */
    int updateTopic(TeacherUpdateTopicRequest request);

    /**
     * 课题列表
     * @param request
     * @return
     */
    List<TeacherTopicVO> getTopicList(TeacherGetTopicsRequest request);

}

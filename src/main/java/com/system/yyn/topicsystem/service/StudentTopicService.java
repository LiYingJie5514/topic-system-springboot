package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.business.response.BaseResponse;

public interface StudentTopicService {

    /**
     * 选课题
     * @return
     */
    BaseResponse selectTopic(String topicId, String studentId);

    /**
     * 审核
     * @return
     */
    int check(String topicId,String studentId,int status);



}

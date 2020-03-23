package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.business.response.BaseResponse;

public interface StudentTopicService {

    /**
     * 选课题
     * @return
     */
    BaseResponse selectTopic(String topicId, String studentId);

    /**
     * 退选
     * @return
     */
    int quitTopic(String topicId,String studentId);



}

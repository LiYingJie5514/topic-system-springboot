package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.business.request.GetTopicListRequest;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.TopicVO;

import java.util.List;

public interface TopicService {

    /**
     * 查看课题信息
     * @return
     */
    Topic getTopicInfo(String topicId);


    List<TopicVO> getTopicList(GetTopicListRequest request);

}

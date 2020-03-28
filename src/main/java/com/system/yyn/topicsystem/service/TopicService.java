package com.system.yyn.topicsystem.service;

import com.system.yyn.topicsystem.business.request.GetTopicListRequest;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.DepTopicVO;
import com.system.yyn.topicsystem.entity.vo.TopicVO;

import java.util.List;

public interface TopicService {

    /**
     * 查看课题信息
     *
     * @return
     */
    Topic getTopicInfo(String topicId);

    /**
     * 获取历届选题
     *
     * @param request
     * @return
     */
    List<TopicVO> getTopicList(GetTopicListRequest request);

    /**
     * 修改选题
     *
     * @param topic
     * @return
     */
    int updateTopicInfo(Topic topic);

    /**
     * 获取课题列表
     * @param status
     * @return
     */
    List<DepTopicVO> getDepTopics(String status,String cellphone);

    /**
     * 审核课题
     * @param topic
     * @return
     */
    int checkTopic(Topic topic);

}

package com.system.yyn.topicsystem.service.impl;

import com.system.yyn.topicsystem.business.request.GetTopicListRequest;
import com.system.yyn.topicsystem.entity.dto.GetTopicListDto;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.TopicVO;
import com.system.yyn.topicsystem.mapper.TopicMapper;
import com.system.yyn.topicsystem.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName : TopicServiceImpl
 * @Description : 课题接口
 */
@Service
public class TopicServiceImpl implements TopicService {

    @Resource
    private TopicMapper topicMapper;

    @Override
    public Topic getTopicInfo(String topicId) {
        Topic topic = topicMapper.getTopic(topicId);
        return topic;
    }

    @Override
    public List<TopicVO> getTopicList(GetTopicListRequest request) {
        GetTopicListDto getTopicListDto = new GetTopicListDto(request);
        List<TopicVO> topicList = topicMapper.getTopicList(getTopicListDto);
        return topicList;
    }
}

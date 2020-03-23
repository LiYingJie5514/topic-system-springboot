package com.system.yyn.topicsystem.mapper;

import com.system.yyn.topicsystem.entity.dto.GetTopicListDto;
import com.system.yyn.topicsystem.entity.po.Topic;
import com.system.yyn.topicsystem.entity.vo.TopicVO;

import java.util.List;

public interface TopicMapper {

    int insert(Topic topic);

    long getId();

    int update(Topic topic);

    Topic getTopic(String topicId);

    List<TopicVO> getTopicList(GetTopicListDto getTopicListDto);
}

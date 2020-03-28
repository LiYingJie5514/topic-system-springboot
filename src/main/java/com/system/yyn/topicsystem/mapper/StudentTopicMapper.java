package com.system.yyn.topicsystem.mapper;

import com.system.yyn.topicsystem.entity.dto.GetTopicListDto;
import com.system.yyn.topicsystem.entity.dto.StudentGetTopicsDto;
import com.system.yyn.topicsystem.entity.po.StudentTopic;
import com.system.yyn.topicsystem.entity.vo.StudentTopicVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentTopicMapper {

    int insert(StudentTopic studentTopic);

    int update(StudentTopic studentTopic);

    List<StudentTopicVO> getList(StudentGetTopicsDto studentGetTopicsDto);

    StudentTopic get(@Param("studentId") String studentId, @Param("topicId") String topicId);
}

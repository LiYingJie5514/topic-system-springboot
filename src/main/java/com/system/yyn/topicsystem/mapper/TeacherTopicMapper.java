package com.system.yyn.topicsystem.mapper;

import com.system.yyn.topicsystem.entity.po.TeacherTopic;
import com.system.yyn.topicsystem.entity.vo.TeacherTopicVO;

import java.util.List;

public interface TeacherTopicMapper {

    int insert(TeacherTopic teacherTopic);

    int delete(TeacherTopic teacherTopic);

    List<TeacherTopicVO> getTopicList(String teacherId);
}

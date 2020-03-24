package com.system.yyn.topicsystem.entity.po;

import java.io.Serializable;

/**
 * @description: 教师课题
 */
public class TeacherTopic implements Serializable {
    private static final long serialVersionUID = 7878637426803731655L;

    private String teacherId;

    private String topicId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }
}

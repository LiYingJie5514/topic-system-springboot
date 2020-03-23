package com.system.yyn.topicsystem.entity.po;

import java.io.Serializable;

/**
 * @author : lyj
 * @description:
 * @date :2020/3/22  17:16
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

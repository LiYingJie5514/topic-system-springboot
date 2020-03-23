package com.system.yyn.topicsystem.entity.vo;

import java.io.Serializable;

/**
 * @ClassName : StudentTopicVO
 * @Description : 学生选课列表展示类
 */
public class StudentTopicVO implements Serializable {
    private static final long serialVersionUID = -3968957653186563166L;

    private String topicTitle;

    private String teacherName;

    private String status;//0已选 1未选

    private String topicPeriod;

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTopicPeriod() {
        return topicPeriod;
    }

    public void setTopicPeriod(String topicPeriod) {
        this.topicPeriod = topicPeriod;
    }
}

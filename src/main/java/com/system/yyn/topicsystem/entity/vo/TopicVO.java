package com.system.yyn.topicsystem.entity.vo;

import java.io.Serializable;

/**
 * @ClassName : TopicVO
 * @Description : 历届课题展示类
 */
public class TopicVO implements Serializable {
    private static final long serialVersionUID = 540957873289974433L;

    private String topicTitle;

    private String topicPeriod;

    private String teacherName;

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicPeriod() {
        return topicPeriod;
    }

    public void setTopicPeriod(String topicPeriod) {
        this.topicPeriod = topicPeriod;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

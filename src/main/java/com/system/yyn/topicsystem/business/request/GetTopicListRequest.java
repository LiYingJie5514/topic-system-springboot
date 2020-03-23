package com.system.yyn.topicsystem.business.request;

import java.io.Serializable;

/**
 * @ClassName : GetTopicListRequest
 * @Description :
 * @Author : lyj
 * @Date: 2020-03-23 17:14
 */
public class GetTopicListRequest implements Serializable {
    private static final long serialVersionUID = 3210095365466448427L;

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

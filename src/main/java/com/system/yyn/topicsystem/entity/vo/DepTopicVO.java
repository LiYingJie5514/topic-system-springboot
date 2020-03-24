package com.system.yyn.topicsystem.entity.vo;

import java.io.Serializable;

/**
 * @ClassName : DepTopicVO
 * @Description :系主任审核页面课题列表
 */
public class DepTopicVO implements Serializable {
    private static final long serialVersionUID = -2643703176636709189L;

    private String topicId;

    private String topicTitle;

    private String teacherName;

    private String period;

    private String status;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.system.yyn.topicsystem.business.request;

import java.io.Serializable;

/**
 * @description: 教师添加课题
 */
public class TeacherAddTopicRequest implements Serializable {
    private static final long serialVersionUID = -2329567925566324375L;

    private String teacherId;

    private String topicTitle;

    private String topicContent;

    private String deadline;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}

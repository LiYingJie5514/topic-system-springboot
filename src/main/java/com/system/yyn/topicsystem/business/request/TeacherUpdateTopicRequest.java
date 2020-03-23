package com.system.yyn.topicsystem.business.request;

import java.io.Serializable;

/**
 * @ClassName : TeacherUpdateTopicRequest
 * @Description :教师修改课题
 */
public class TeacherUpdateTopicRequest implements Serializable {
    private static final long serialVersionUID = 8386711381785816525L;

    private String topicId;

    private String topicTitle;

    private String topicContent;

    private String topicStatus;

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

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(String topicStatus) {
        this.topicStatus = topicStatus;
    }
}

package com.system.yyn.topicsystem.business.request;

import java.io.Serializable;

/**
 * @author : lyj
 * @description:
 * @date :2020/3/22  17:40
 */
public class AddTopicRequest implements Serializable {
    private static final long serialVersionUID = -2329567925566324375L;

    private String teacherId;

    private String topicTitle;

    private String topicContent;

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
}

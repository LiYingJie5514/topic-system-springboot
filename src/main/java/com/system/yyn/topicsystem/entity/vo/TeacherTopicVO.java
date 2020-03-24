package com.system.yyn.topicsystem.entity.vo;

import java.io.Serializable;

/**
 * @description: 教师课题列表展示类
 */
public class TeacherTopicVO implements Serializable {
    private static final long serialVersionUID = 4905330782764302587L;

    private String topicId;

    private String topicTitle;

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

}

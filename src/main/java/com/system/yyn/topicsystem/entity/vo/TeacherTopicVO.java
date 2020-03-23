package com.system.yyn.topicsystem.entity.vo;

import java.io.Serializable;

/**
 * @author : lyj
 * @description:
 * @date :2020/3/22  17:29
 */
public class TeacherTopicVO implements Serializable {
    private static final long serialVersionUID = 4905330782764302587L;

    private String topicTitle;

    private String topicContent;

    private int studentNum;

    private String status;

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

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

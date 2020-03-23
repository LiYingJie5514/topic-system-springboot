package com.system.yyn.topicsystem.entity.po;

import java.io.Serializable;

/**
 * @author : lyj
 * @description:
 * @date :2020/3/22  17:22
 */
public class StudentTopic implements Serializable {
    private static final long serialVersionUID = 7190642364418780394L;

    private String studentId;

    private String topicId;

    private int status;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

package com.system.yyn.topicsystem.entity.po;

import java.io.Serializable;

/**
 * @description: 学生课题
 */
public class StudentTopic implements Serializable {
    private static final long serialVersionUID = 7190642364418780394L;

    private String studentId;

    private String topicId;

    private int status; //0选择 1退选

    private String reason;//选择理由

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

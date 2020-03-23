package com.system.yyn.topicsystem.entity.vo;

import java.io.Serializable;

/**
 * @description: 教师课题列表展示类
 */
public class TeacherTopicVO implements Serializable {
    private static final long serialVersionUID = 4905330782764302587L;

    private String topicTitle;

    private int studentNum;//选题人数

    private String status;//状态

    private String deadline;//截止时间

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}

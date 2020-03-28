package com.system.yyn.topicsystem.business.request;

import java.io.Serializable;

/**
 * @ClassName : StudentGetTopicsRequest
 * @Description : 学生获取课题列表
 */
public class StudentGetTopicsRequest implements Serializable {
    private static final long serialVersionUID = -4609657662833421539L;

    private String teacherName;

    private String status;

    private String studentId;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

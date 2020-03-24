package com.system.yyn.topicsystem.entity.dto;

import com.system.yyn.topicsystem.business.request.StudentGetTopicsRequest;

import java.io.Serializable;

/**
 * @ClassName : StudentGetTopicsDto
 * @Description :获取课题列表dto
 */
public class StudentGetTopicsDto implements Serializable {
    private static final long serialVersionUID = -2153600725475087741L;

    private String teacherName;

    private String status;

    public StudentGetTopicsDto(StudentGetTopicsRequest request){
        this.teacherName = request.getTeacherName();
        this.status = request.getStatus();
    }

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
}

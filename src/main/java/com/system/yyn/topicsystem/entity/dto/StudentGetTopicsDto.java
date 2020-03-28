package com.system.yyn.topicsystem.entity.dto;

import com.system.yyn.topicsystem.business.request.StudentGetTopicsRequest;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @ClassName : StudentGetTopicsDto
 * @Description :获取课题列表dto
 */
public class StudentGetTopicsDto implements Serializable {
    private static final long serialVersionUID = -2153600725475087741L;

    private String teacherName;

    private String studentId;

    private String period;

    public StudentGetTopicsDto(StudentGetTopicsRequest request){
        this.teacherName = StringUtils.isNotBlank(request.getTeacherName()) ? request.getTeacherName().trim() : "";
        this.studentId = request.getStudentId();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}

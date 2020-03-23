package com.system.yyn.topicsystem.business.request;

import java.io.Serializable;

/**
 * @ClassName : TeacherGetTopicsRequest
 * @Description :获取课题列表
 */
public class TeacherGetTopicsRequest implements Serializable {
    private static final long serialVersionUID = 7094324300323703117L;

    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}

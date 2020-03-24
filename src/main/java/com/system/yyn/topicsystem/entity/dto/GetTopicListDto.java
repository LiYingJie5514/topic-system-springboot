package com.system.yyn.topicsystem.entity.dto;

import com.system.yyn.topicsystem.business.request.GetTopicListRequest;

import java.io.Serializable;

/**
 * @ClassName : GetTopicListDto
 * @Description :
 */
public class GetTopicListDto implements Serializable {
    private static final long serialVersionUID = 645477381033207877L;

    private String topicTitle;

    private String topicPeriod;

    private String teacherName;

    public GetTopicListDto(GetTopicListRequest request) {
        this.topicPeriod = request.getTopicPeriod();
        this.topicTitle = request.getTopicTitle();
        this.teacherName = request.getTeacherName();
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicPeriod() {
        return topicPeriod;
    }

    public void setTopicPeriod(String topicPeriod) {
        this.topicPeriod = topicPeriod;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

package com.system.yyn.topicsystem.entity.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 课题信息
 */
public class Topic implements Serializable {
    private static final long serialVersionUID = 8097658796288497727L;

    private long topicId;

    private String topicPeriod;

    private String topicTitle;

    private String topicContent;

    private int topicStatus; //0正常 1下架

    private Date deadline;//截止日期

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

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

    public int getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(int topicStatus) {
        this.topicStatus = topicStatus;
    }

    public String getTopicPeriod() {
        return topicPeriod;
    }

    public void setTopicPeriod(String topicPeriod) {
        this.topicPeriod = topicPeriod;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}

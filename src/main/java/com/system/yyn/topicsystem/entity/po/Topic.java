package com.system.yyn.topicsystem.entity.po;

import java.io.Serializable;

/**
 * @description: 课题信息
 */
public class Topic implements Serializable {
    private static final long serialVersionUID = 8097658796288497727L;

    private long topicId;

    private String topicPeriod;

    private String topicTitle;

    private String topicContent;

    private String status;//0待审核 1审核通过 2审核不通过

    private String comment;//系主任备注

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

    public String getTopicPeriod() {
        return topicPeriod;
    }

    public void setTopicPeriod(String topicPeriod) {
        this.topicPeriod = topicPeriod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

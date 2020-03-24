package com.system.yyn.topicsystem.entity.po;

import java.io.Serializable;

/**
 * @ClassName : Bulletin
 * @Description : 公告
 */
public class Bulletin implements Serializable {
    private static final long serialVersionUID = -7538507507477968566L;

    private long id;

    private String title;

    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

package com.system.yyn.topicsystem.business.response;

import java.io.Serializable;

/**
 * @ClassName : BaseResponse
 * @Description : 返回类
 */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 9202166361820150723L;

    private String status;

    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

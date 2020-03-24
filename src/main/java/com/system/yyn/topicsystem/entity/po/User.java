package com.system.yyn.topicsystem.entity.po;

import java.io.Serializable;

/**
 * @description: 用户信息
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6235965638637862469L;

    private String userName;
    private String passWord;
    private String cellphone;
    private String userType; //0 学生 1教师 2系主任 3系统管理员

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

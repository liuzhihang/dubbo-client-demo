package com.liuzhihang.dubbo.nacos.service.dto;

import java.io.Serializable;

/**
 * @author liuzhihang
 * @date 2021/9/6 18:22
 */
public class UserQueryResponse implements Serializable {

    private String userId;

    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

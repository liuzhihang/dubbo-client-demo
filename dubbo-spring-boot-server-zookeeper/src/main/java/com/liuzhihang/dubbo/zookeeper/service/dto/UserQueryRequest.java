package com.liuzhihang.dubbo.zookeeper.service.dto;

import java.io.Serializable;

/**
 * @author liuzhihang
 * @date 2021/9/6 18:22
 */
public class UserQueryRequest implements Serializable {

    private String userId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

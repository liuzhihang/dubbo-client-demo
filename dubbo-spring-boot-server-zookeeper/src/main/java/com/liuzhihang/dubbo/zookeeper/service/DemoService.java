package com.liuzhihang.dubbo.zookeeper.service;

import com.liuzhihang.dubbo.zookeeper.service.dto.UserQueryRequest;
import com.liuzhihang.dubbo.zookeeper.service.dto.UserQueryResponse;

public interface DemoService {

    /**
     * 官方 demo
     *
     * @param name
     * @return
     */
    String sayHello(String name);

    /**
     * 查询用户
     *
     * @param request
     * @return
     */
    UserQueryResponse queryUser(UserQueryRequest request);


}

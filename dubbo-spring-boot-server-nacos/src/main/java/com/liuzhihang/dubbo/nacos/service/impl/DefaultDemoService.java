package com.liuzhihang.dubbo.nacos.service.impl;

import com.liuzhihang.dubbo.nacos.service.DemoService;
import com.liuzhihang.dubbo.nacos.service.dto.UserQueryRequest;
import com.liuzhihang.dubbo.nacos.service.dto.UserQueryResponse;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

@DubboService
public class DefaultDemoService implements DemoService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @Override
    public UserQueryResponse queryUser(UserQueryRequest request) {

        UserQueryResponse response = new UserQueryResponse();
        response.setUserId(request.getUserId());
        response.setUserName("liuzhihang");
        return response;
    }
}

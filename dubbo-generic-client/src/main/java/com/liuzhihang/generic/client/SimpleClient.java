package com.liuzhihang.generic.client;

import com.alibaba.fastjson.JSON;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * 直接调用 dubbo 协议接口,没有注册中心
 *
 * @author liuzhihang
 * @date 2021/9/6 17:44
 */
public class SimpleClient {


    public static void main(String[] args) {

        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("generic-consumer"));
        reference.setInterface("com.liuzhihang.dubbo.simple.service.DemoService");
        reference.setUrl("dubbo://127.0.0.1:12345");
        // 声明为泛化
        reference.setGeneric(true);
        GenericService genericService = reference.get();

        Object invoke = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"SimpleClient"});

        System.out.println("invoke = " + JSON.toJSONString(invoke));


    }
}

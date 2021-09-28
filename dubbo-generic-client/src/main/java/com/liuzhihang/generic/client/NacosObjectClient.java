package com.liuzhihang.generic.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * 当注册中心是 Nacos 时的泛化调用
 * <p>
 * 参数是对象
 *
 * @author liuzhihang
 * @date 2021/9/6 18:06
 */
public class NacosObjectClient {

    public static void main(String[] args) {

        //注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("nacos://10.246.121.243:8848");

        //应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("generic-consumer");

        // 引用远程服务
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        // 弱类型接口名
        reference.setInterface("com.liuzhihang.dubbo.nacos.service.DemoService");
        reference.setRegistry(registryConfig);
        reference.setApplication(applicationConfig);
        // 声明为泛化接口
        reference.setGeneric(true);

        // 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", "test");

        Object invoke = genericService.$invoke("queryUser", new String[]{"com.liuzhihang.dubbo.nacos.service.dto.UserQueryRequest"}, new Object[]{jsonObject});

        System.out.println("invoke = " + JSON.toJSONString(invoke));

    }

}

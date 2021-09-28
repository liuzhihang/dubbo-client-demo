package com.liuzhihang.generic.client;

import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * json 泛化调用
 *
 * @author liuzhihang
 * @date 2021/9/7 21:08
 */
public class JsonGenericClient {

    public static void main(String[] args) {

        ApplicationConfig app = new ApplicationConfig("ConsumerTest");
        RegistryConfig reg = new RegistryConfig("zookeeper://10.246.121.243:2181");

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(app);
        bootstrap.registry(reg);
        bootstrap.start();

        try {
            // 引用远程服务
            ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
            // 弱类型接口名
            reference.setInterface("com.liuzhihang.dubbo.zookeeper.service.DemoService");
            // reference.setGroup("dev");
            // reference.setVersion("1.0");
            reference.setRetries(0);
            // RpcContext中设置generic=gson
            RpcContext.getContext().setAttachment("generic", "gson");
            // 声明为泛化接口
            reference.setGeneric(true);
            reference.setCheck(false);
            GenericService genericService = ReferenceConfigCache.getCache().get(reference);
            // 传递参数对象的json字符串进行一次调用
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", "test");

            Object invoke = genericService.$invoke("queryUser", new String[]{"com.liuzhihang.dubbo.zookeeper.service.dto.UserQueryRequest"}, new Object[]{jsonObject});
            System.out.println("result[setUser]：" + invoke);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }
}

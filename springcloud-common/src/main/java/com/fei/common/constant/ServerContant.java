package com.fei.common.constant;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/5
 * @Description: 服务常量
 */
public class ServerContant {

    /**
     * 工具类不可被实例化，所以最好添加一个私有的构造器，指明不可被实例化
     */
    private ServerContant() {
    }

    /**
     * 服务提供者的application.name
     */
    public static final String SERVER_PROVIDER = "SPRINGCLOUD-EMPLOYEE-PROVIDER-FEIGN";
    public static final String SERVER_PROVIDER_BEFORE_HTTP = "http://SPRINGCLOUD-EMPLOYEE-PROVIDER";
    public static final String SERVER_PROVIDER_BEFORE = "SPRINGCLOUD-EMPLOYEE-PROVIDER";

    /**
     * 服务提供者的url
     */
    public static final String REST_URL = "http://127.0.0.1:8081";
}

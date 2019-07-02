package com.fei.springcloudconsumer.consumer.employee;

import com.alibaba.fastjson.JSON;
import com.fei.common.enums.SexEnum;
import com.fei.common.model.employee.EmployeeModel;
import com.fei.springcloudconsumer.date.model.WebEmployeeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 员工消费端（控制器）
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    /**
     * 定义url常量
     */
    private static final String REST_URL = "http://127.0.0.1:8081";
    private static final String REST_URL_NAME = "http://SPRINGCLOUD-EMPLOYEE-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取员工列表，调用服务 1. 通过RestTemplate调用服务，get请求参数列表：url、返回值类型（参数列表写在url中） 2.
     * 通过RestTemplate调用服务，post请求参数列表：url、参数列表、返回值类型
     * Eureka存在情况下，该请求会报错
     */
    @GetMapping("/list")
    public List<EmployeeModel> list() {
        return restTemplate.getForObject(REST_URL + "/emp/list", List.class);
    }

    /**
     * 获取员工列表，从eureka调用服务（使用application name代替ip+端口） 1.
     * 通过RestTemplate调用服务，get请求参数列表：url、返回值类型（参数列表写在url中），返回值类型是指以什么类型接受响应体内容 2.
     * 通过RestTemplate调用服务，post请求参数列表：url、参数列表、返回值类型
     */
    @GetMapping("/list2")
    public List<WebEmployeeModel> list2() {
        // 将响应体内容以String格式接受，即json字符串
        String json = restTemplate.getForObject(REST_URL_NAME + "/emp/list", String.class);
        // 将json字符串转集合
        List<EmployeeModel> employeeModels = JSON.parseArray(json, EmployeeModel.class);
        List<WebEmployeeModel> webEmployeeModels = new ArrayList<>();
        employeeModels.forEach(employeeModel -> {
            WebEmployeeModel webEmployeeModel = new WebEmployeeModel();
            // 使用Spring的工具进行属性拷贝
            BeanUtils.copyProperties(employeeModel, webEmployeeModel, WebEmployeeModel.class);
            // 性别描述
            webEmployeeModel.setEmployeeSexDesc(
                    Optional.ofNullable(SexEnum.getByCode(webEmployeeModel.getEmployeeSex()))
                            .map(SexEnum::getSexDesc).orElse("未知"));
            webEmployeeModels.add(webEmployeeModel);
        });
        return webEmployeeModels;
    }
}

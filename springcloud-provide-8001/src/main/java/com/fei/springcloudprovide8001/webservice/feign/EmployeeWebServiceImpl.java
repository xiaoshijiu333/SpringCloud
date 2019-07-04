package com.fei.springcloudprovide8001.webservice.feign;

import com.alibaba.fastjson.JSON;
import com.fei.common.model.employee.EmployeeModel;
import com.fei.springcloudprovide8001.employee.EmployeeService;
import feign.webservice.EmployeeWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/4
 * @Description: 员工feign接口实现类
 */
@RestController
public class EmployeeWebServiceImpl implements EmployeeWebService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<EmployeeModel> list() {
        // 使用阿里巴巴的fastjson进行集合中对象的模型转换
        return JSON.parseArray(JSON.toJSONString(employeeService.list()), EmployeeModel.class);
    }
}

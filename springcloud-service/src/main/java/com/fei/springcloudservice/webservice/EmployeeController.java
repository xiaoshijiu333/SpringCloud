package com.fei.springcloudservice.webservice;

import com.alibaba.fastjson.JSON;
import com.fei.common.model.employee.EmployeeModel;
import com.fei.springcloudservice.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 员工服务controller，也是对外接口，在这里完成模型变换（model和entity的转换）
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询员工列表
     * @return List<EmployeeModel>
     */
    @GetMapping("/list")
    public List<EmployeeModel> list() {
        // 使用阿里巴巴的fastjson进行集合中对象的模型转换
        List<EmployeeModel> employeeModels = JSON
                .parseArray(JSON.toJSONString(employeeService.list()), EmployeeModel.class);
        return employeeModels;
    }

}

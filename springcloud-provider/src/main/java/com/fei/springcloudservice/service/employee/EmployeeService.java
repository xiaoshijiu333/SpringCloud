package com.fei.springcloudservice.service.employee;

import com.fei.springcloudservice.data.entity.Employee;

import java.util.List;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 员工服务层接口
 */
public interface EmployeeService {
    /**
     * 查询员工列表
     * @return List<EmployeeModel>
     */
    List<Employee> list();
}

package com.fei.springcloudservicefeign8002.employee;


import com.fei.springcloudservicefeign8002.data.entity.Employee;
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

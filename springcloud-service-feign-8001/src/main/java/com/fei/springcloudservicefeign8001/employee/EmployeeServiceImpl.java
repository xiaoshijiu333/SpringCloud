package com.fei.springcloudservicefeign8001.employee;

import java.util.List;

import com.fei.springcloudservicefeign8001.data.entity.Employee;
import com.fei.springcloudservicefeign8001.data.mapper.EmplMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 员工服务层接口实现类，约定模型（model）不进service里面
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmplMapper emplMapper;

    @Override
    public List<Employee> list() {
        Example example = new Example(Employee.class);
        example.createCriteria().andEqualTo(Employee.DELETE_TIME, Employee.DELETE_TIME_NO);
        // 创建时间倒叙
        example.orderBy(Employee.CREATE_TIME).desc();
        return emplMapper.selectByExample(example);
    }
}

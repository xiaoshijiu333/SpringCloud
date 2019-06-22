package com.fei.common.model.employee;

import com.fei.common.data.BaseObject;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 员工模型和entity对应
 */
@Getter
@Setter
public class EmployeeModel extends BaseObject implements Serializable {
    private static final long serialVersionUID = 5336128105870854037L;
    private Integer employeeId;
    private String employeeName;
    private Integer employeeSex;
}

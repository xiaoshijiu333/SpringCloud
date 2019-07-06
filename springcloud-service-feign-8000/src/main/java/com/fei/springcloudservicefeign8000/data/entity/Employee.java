package com.fei.springcloudservicefeign8000.data.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fei.common.data.BaseObject;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 员工实体类
 */
@Table(name = "employee")
@Getter
@Setter
public class Employee extends BaseObject {

    /**
     * 定义常量字段
     */
    public static final String EMPLOYEE_ID = "employeeId";
    @Id
    private Integer employeeId;

    public static final String EMPLOYEE_NAME = "employeeName";
    private String employeeName;

    public static final String EMPLOYEE_SEX = "employeeSex";
    private Integer employeeSex;
}

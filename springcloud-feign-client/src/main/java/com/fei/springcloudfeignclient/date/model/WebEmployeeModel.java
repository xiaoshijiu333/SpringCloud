package com.fei.springcloudfeignclient.date.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fei.common.constant.DateConstant;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/23
 * @Description: 员工Web返回模型
 */
@Setter
@Getter
public class WebEmployeeModel {
    private Integer employeeId;
    private String employeeName;
    /**
     * 性别
     */
    private Integer employeeSex;
    /**
     * 性别描述
     */
    private String employeeSexDesc;
    @JsonFormat(pattern = DateConstant.DATE_FORMAT1, timezone = DateConstant.TIME_ZONE)
    private Date createTime;
}

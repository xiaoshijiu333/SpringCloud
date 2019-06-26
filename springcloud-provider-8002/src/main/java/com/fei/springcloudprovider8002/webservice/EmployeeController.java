package com.fei.springcloudprovider8002.webservice;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.fei.springcloudprovider8002.config.log.Loggable;
import com.fei.springcloudprovider8002.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.fei.common.model.employee.EmployeeModel;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: 员工服务controller，也是对外接口，在这里完成模型变换（model和entity的转换）
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController implements Loggable {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 查询员工列表
     * @return List<EmployeeModel>
     */
    @GetMapping("/list")
    public List<EmployeeModel> list() {
        // 日志一下url地址
        getLog().info(request.getRequestURL().toString());
        // 使用阿里巴巴的fastjson进行集合中对象的模型转换
        return JSON.parseArray(JSON.toJSONString(employeeService.list()), EmployeeModel.class);
    }

}

package feign.webservice;

import com.fei.common.constant.ServerContant;
import com.fei.common.model.employee.EmployeeModel;
import feign.hystrix.EmployeeFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/4
 * @Description: 员工feign接口
 * @FeignClient: name表示为哪个服务配置feign申明式服务调用，fallback表示服务出现异常或者超时时去执行的类
 */
@FeignClient(name = ServerContant.SERVER_PROVIDER, fallback = EmployeeFallBack.class)
@RequestMapping("/feign/empl")
public interface EmployeeWebService {

    /**
     * 查询所有员工
     * @return 员工模型列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    List<EmployeeModel> list();

}

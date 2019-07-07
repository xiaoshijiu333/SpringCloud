package feign.hystrix;

import java.util.List;
import com.fei.common.log.Loggable;
import org.springframework.stereotype.Component;
import com.fei.common.model.employee.EmployeeModel;
import feign.webservice.EmployeeWebService;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/7
 * @Description: Feign接口，服务降级操作（服务出现异常或者超过设定时间，即执行该降级方法）
 * @注意：这个实际是需要被加入到IOC容器中的，实现接口也会继承她的Requestmapping，所以这里要重写一下区分开，不然启动报错
 */
@Component
@RequestMapping("/fallback/empl")
public class EmployeeFallBack implements EmployeeWebService, Loggable {

    @Override
    public List<EmployeeModel> list() {
        getLog().error("服务提供异常，进行了服务降级处理");
        return null;
    }
}

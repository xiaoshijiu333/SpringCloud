package com.fei.springcloudzuulconfig5001.filter;

import javax.servlet.RequestDispatcher;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.fei.common.log.Loggable;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/13
 * @Description: 自定义Zuul过滤器
 * @Component: 需要让Spring知道他的存在，即加入IOC容器中
 */
@Component
public class MyTestFilter extends ZuulFilter implements Loggable {

    /**
     * 判断是否需要执行error过滤器的条件常量
     */
    private static final String SEND_ERROR_FILTER_RAN = "sendErrorFilter.ran";

    /**
     * 过滤器类型
     * @pre: 请求过来就执行，最先
     * @routh：路由阶段，决定如何进行路由
     * @post：路由之后执行的过滤器
     * @error：发生异常时执行的过滤器
     */
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    /**
     * 执行顺序，数字越小表示执行顺序越靠前
     * @这里设置为1，在routh中是最小的了
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否执行
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String uri = ctx.getRequest().getRequestURI();
        // 这里指定一下具体执行的路径
        if (uri.indexOf("/fortest") != -1) {
            return true;
        }
        return false;
    }

    /**
     * 具体处理逻辑
     */
    @Override
    public Object run() throws ZuulException {
        getLog().warn("用于测试的zuul过滤器来了！！");
        RequestContext ctx = RequestContext.getCurrentContext();
        RequestDispatcher dispatcher = ctx.getRequest().getRequestDispatcher("/error");
        if (dispatcher != null) {
            // 设置为true，表示不会再去执行error过滤器了
            ctx.set(SEND_ERROR_FILTER_RAN, true);
            // 设置为false，表示不会再去执行其他过滤器了
            ctx.setSendZuulResponse(false);
            try {
                // 转发
                dispatcher.forward(ctx.getRequest(), ctx.getResponse());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

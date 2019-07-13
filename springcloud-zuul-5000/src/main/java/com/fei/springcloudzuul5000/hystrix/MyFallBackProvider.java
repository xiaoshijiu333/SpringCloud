package com.fei.springcloudzuul5000.hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/13
 * @Description: Zuul中使用Hystrix处理回退
 * @Component需要将其加到IOC容器中
 */
@Component
public class MyFallBackProvider implements FallbackProvider {

    /**
     * 返回路由的名称，表示对哪个路由处理，”*“表示对所有服务处理
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 具体回退返回逻辑，一个Http响应
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {

            /**
             * 响应头
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.TEXT_PLAIN);
                return httpHeaders;
            }

            /**
             * 响应体
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("当前服务不可用，请稍后再试".getBytes());
            }

            /**
             * 响应码，状态码
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            /**
             * 数字类型的状态码
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            /**
             * 响应状态文本
             */
            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            /**
             * 用于释放资源
             */
            @Override
            public void close() {

            }
        };
    }
}

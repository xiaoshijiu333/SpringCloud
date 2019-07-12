# SpringCloud
SpringCloud入门学习
1. Eureka服务端，服务提供，服务消费
2. Eureka集群，两个注册中心，三个服务提供者
3. 自定义Ribbon负载均衡算法
4. 开发模式下关闭了Eureka的自我保护机制，并修改了维护心跳时间间隔以及清理实例时间间隔
5. Feign使用方式——服务提供者实现接口的形式
6. 添加Hystrix和Hystrix Dashboard
7. 添加zuul路由转发
8.  -   springcloud-common：公共类，工具
    -   springcloud-consumer：使用Restemplate的消费端
    -   springcloud-eureka-service：Eureka注册中心，端口7000
    -   springcloud-eureka-service-7001：Eureka注册中心，端口7001
    -   springcloud-feign-client：使用Feign的服务消费端
    -   springcloud-hystrix-dashboard-6060-second：hystrix dashboard服务监控
    -   springcloud-interface-feign：feign公共接口
    -   springcloud-provide-8001：常规（没有使用feign）的服务提供者，端口8001
    -   springcloud-provider：常规（没有使用feign）的服务提供者，端口8000
    -   springcloud-provide-8002：常规（没有使用feign）的服务提供者，端口8002
    -   springcloud-service-feign-8000：使用feign的服务提供者，端口8000
    -   springcloud-service-feign-8001：使用feign的服务提供者，端口8001
    -   springcloud-service-feign-8002：使用feign的服务提供者，端口8002
    -   springcloud-zuul-5000：使用zuul路由转发
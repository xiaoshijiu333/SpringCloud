package com.fei.ribbon.config;

import com.fei.springcloudconsumer.config.log.Loggable;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/7/2
 * @Description: 自定义负载均衡算法，每个服务轮询3次。 官方文档指出：
 *               这个自定义的类不能放在@ComponentScan所扫描的当前包以及子包下，
 *               否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享， 也就是我们达不到特殊化指定的目的了。
 */
public class MyRule extends AbstractLoadBalancerRule implements Loggable {

    private AtomicInteger nextServerCyclicCounter;
    // 定义轮询次数
    private AtomicInteger totle;

    public MyRule() {
        nextServerCyclicCounter = new AtomicInteger(0);
        totle = new AtomicInteger(0);
    }

    public MyRule(ILoadBalancer lb) {
        this();
        setLoadBalancer(lb);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            getLog().warn("no load balancer");
            return null;
        }

        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                getLog().warn("No up servers available from load balancer: " + lb);
                return null;
            }

            int nextServerIndex = myincrementAndGetModulo(serverCount);
            server = allServers.get(nextServerIndex);

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }

        if (count >= 10) {
            getLog().warn("No available alive servers after 10 tries from load balancer: " + lb);
        }
        return server;
    }

    /**
     * 具体实现算法。可能写的不好，实现效果
     */
    private int myincrementAndGetModulo(int modulo) {
        for (;;) {
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            // 预期一样的话就把value更新为next
            if (totle.get() < 3 && nextServerCyclicCounter.compareAndSet(current, current)) {
                // 获取并自增
                totle.getAndIncrement();
                if (totle.get() == 3) {
                    // 重新赋值
                    totle.getAndSet(0);
                    nextServerCyclicCounter.getAndSet(next);
                }
                return next;
            }
        }
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}

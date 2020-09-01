package com.learning.springcloud.feign.rule;

import com.learning.springcloud.feign.util.ThreadLocalUtil;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

import java.util.List;
import java.util.Map;

public class GrayRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(), o);
    }

    public Server choose(ILoadBalancer lb, Object o) {

        Map<String, String> map = ThreadLocalUtil.get();

        if(map != null && map.containsKey("version")) {
            String version = map.get("version");

            if(version != null) {
                List<Server> reachableServers = lb.getReachableServers();
                for (Server reachableServer : reachableServers) {
                    DiscoveryEnabledServer discoveryEnabledServer = ((DiscoveryEnabledServer) reachableServer);
                    Map<String, String> metadata = discoveryEnabledServer.getInstanceInfo().getMetadata();

                    if (metadata != null && metadata.containsKey("version") && version.equals(metadata.get("version"))) {
                        return reachableServer;
                    }
                }
            }
        }


        return lb.getReachableServers().get(0);
    }
}

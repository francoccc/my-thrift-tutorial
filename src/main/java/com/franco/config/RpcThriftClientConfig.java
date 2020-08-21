package com.franco.config;

import com.franco.TRpcUserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RpcThriftClientConfig {

    @Value("${thrift.host}")
    private String host;
    @Value("${thrift.port}")
    private int port;

    @Bean(initMethod = "init")
    public TRpcUserClient tRpcUserClient() {
        TRpcUserClient client = new TRpcUserClient();
        client.setHost(host);
        client.setPort(port);
        return client;
    }
}

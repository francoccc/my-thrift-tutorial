package com.franco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * SpringBoot Application BootStrap
 *
 * @author franco
 */
@SpringBootApplication
@MapperScan("com.franco")
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        try {
            RpcThriftServer server = context.getBean(RpcThriftServer.class);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

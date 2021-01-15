package com.pyjava.classip.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>auth启动器</p>
 *
 * @author zhaojj
 * @date 2020-12-29 23:49:01
 * @since v1.0.0-SNAPSHOT
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ClassipAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassipAuthApplication.class, args);
    }

}

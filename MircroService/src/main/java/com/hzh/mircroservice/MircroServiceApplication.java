package com.hzh.mircroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MircroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MircroServiceApplication.class, args);
    }

}

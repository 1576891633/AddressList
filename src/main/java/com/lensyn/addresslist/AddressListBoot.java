package com.lensyn.addresslist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringBoot启动程序
 * Created by lizhongfu on 14:59 2017/12/15
 */
@SpringBootApplication
@EnableEurekaClient
public class AddressListBoot {

    public static void main(String[] args) {
        SpringApplication.run(AddressListBoot.class, args);
    }
}


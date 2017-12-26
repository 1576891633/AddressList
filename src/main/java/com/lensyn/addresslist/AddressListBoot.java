package com.lensyn.addresslist;

import com.lensyn.usercenter.security.client.system.annotation.ExcludeScan;
import com.netflix.ribbon.RequestTemplate;
import feign.RequestInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringBoot启动程序
 * Created by lizhongfu on 14:59 2017/12/15
 */
@ComponentScan(value = "com.lensyn", excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = ExcludeScan.class
))
@EnableScheduling
@EnableCaching
@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@EnableFeignClients(basePackages = "com.lensyn")
@MapperScan("com.lensyn.addresslist.dao")
public class AddressListBoot {

    public static void main(String[] args) {
        SpringApplication.run(AddressListBoot.class, args);
    }
}


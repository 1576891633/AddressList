package com.lensyn.addresslist.system.config;

import com.lensyn.usercenter.security.client.system.config.IgnoreUrlPatterns;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 新增swagger文档访问
 * Created by liudp on 17-8-2.
 */
@Configuration
@Import(SwaggerConfig.class)
public class AppConfig {
    @Bean("ignoreUrls")
    public IgnoreUrlPatterns ignoreUrlPatterns() {
        return new IgnoreUrlPatterns() {
            @Override
            public String[] getPatterns() {
                return new String[]{"/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**"};
            }
        };
    }

}

package com.lensyn.addresslist.system.config;

import org.springframework.context.annotation.Configuration;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lizhongfu on 2017/12/23.
 * 请求头拦截器，添加头信息
 */
@Configuration
public class MyRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String page =  request.getParameter("page");
        String size =  request.getParameter("size");
        //全局，用于一些公共的头
        String items = "items="+page+"-"+size;
        requestTemplate.header("Range",items);
        }
    }



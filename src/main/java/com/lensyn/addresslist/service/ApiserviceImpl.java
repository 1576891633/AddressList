package com.lensyn.addresslist.service;

import com.lensyn.common.utils.system.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by lizhongfu on 14:40 2017/12/18
 * 权限API的fallback
 */
@Component
public class ApiserviceImpl implements ApiService {

    private Logger log = LoggerFactory.getLogger(ApiserviceImpl.class);

    @Override
    public Response getAddressList(String userName, String orgName, String orgCode,
                                   String telephone, String email) {
        log.error("查找通讯录失败");
        return new Response().failure("查找通讯录失败");
    }

    @Override
    public Response updateAddressList(String userName, String telephone, String email,
                                      String orgName, String orgCode, String account) {
        log.error("更新通讯录失败");
        return new Response().failure("更新通讯录失败");
    }

    @Override
    public Response getOrgTree() {
        log.error("获取企业组织树失败");
        return new Response().failure("获取企业组织树失败");
    }

    @Override
    public Response me() {
        log.error("获取登录用户信息失败!");
        return new Response().failure("获取登录用户信息失败!");
    }

    @Override
    public Response getRolesByAccount(String account) {
        log.error("获取用户角色信息失败!");
        return new Response().failure("获取用户角色信息失败!");
    }

}

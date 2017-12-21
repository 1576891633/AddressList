package com.lensyn.addresslist.service;

import com.lensyn.addresslist.entity.PageRequest;
import com.lensyn.common.utils.system.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by lizhongfu on 14:40 2017/12/18
 * 权限API的fallback
 */
@Component
public class ApiserviceImpl implements ApiService {

    private Logger log = LoggerFactory.getLogger(ApiserviceImpl.class);

    @Override
    public Response addressList() {
        return null;
    }

    /*@Override
    public Response getAddressList(String userName, String orgName, Integer enterpriseOrgId, String telephone,
                                   String position, String email, Integer page, Integer rows) {
        log.error("查找通讯录失败");
        return new Response().failure("查找通讯录失败");
    }*/

    @Override
    public Response getAddressList(PageRequest pageRequest) {
        log.error("查找通讯录失败");
        return new Response().failure("查找通讯录失败");
    }

    @Override
    public Response updateAddressList(String userName, String telephone, Integer sex, String email, String identityCard, String info, Integer enterpriseOrgId, String account) {
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

    @Override
    public Response getResourcesTree(String clientId, Integer resType) {
        log.error("获取资源树失败!");
        return new Response().failure("获取资源树失败!");
    }

    @Override
    public Response getOrgTreeByOrgCode(String orgCode) {
        String message = "orgCode:" + orgCode + ",获取组织信息树失败!";
        log.error(message);
        return new Response().failure(message);
    }
}

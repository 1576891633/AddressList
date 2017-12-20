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
    public Response getAddressListByOrgCode(String orgCode) {
        log.error("通过组织Code获取通讯录失败");
        return new Response().failure("通过组织Code获取通讯录失败");
    }

    @Override
    public Response addressList() {
        log.error("获取通讯录失败");
        return new Response().failure("获取通讯录失败");
    }

    @Override
    public Response getAddressListByUserName(String userName) {
        log.error("通过用户名获取通讯录失败");
        return new Response().failure("通过用户名获取通讯录失败");
    }

    @Override
    public Response getAddressListByAccount(String account) {
        log.error("通过账户获取通讯录失败");
        return new Response().failure("通过账户获取通讯录失败");
    }

    @Override
    public Response getAddressListByAccountType(String accountType) {
        log.error("通过账户类型获取通讯录失败");
        return new Response().failure("通过账户类型获取通讯录失败");
    }

    @Override
    public Response getAddressListByCurStatus(String curStatus) {
        log.error("通过当前状态获取通讯录失败");
        return new Response().failure("通过当前状态获取通讯录失败");
    }

    @Override
    public Response getAddressListByTelephone(String telephone) {
        log.error("通过电话获取通讯录失败");
        return new Response().failure("通过电话获取通讯录失败");
    }

    @Override
    public Response getAddressListByIdentityCard(String identityCard) {
        log.error("通过身份证获取通讯录失败");
        return new Response().failure("通过身份证获取通讯录失败");
    }

    @Override
    public Response getAddressListByPosition(String position) {
       log.error("通过职位获取通讯录失败");
       return new Response().failure("通过职位获取通讯录失败");
    }

    @Override
    public Response getAddressListByEmail(String email) {
        log.error("通过邮件获取通讯录失败");
        return new Response().failure("通过邮件获取通讯录失败");
    }

    @Override
    public Response updateAddressList(String userName, String telephone, String position, String sex, String email, String identityCard, String info, String orgName, String orgCode, String account) {
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

package com.lensyn.addresslist.service;

import com.lensyn.common.utils.system.response.Response;
import com.lensyn.usercenter.security.client.system.config.UserCenterApiFeignConfiguration;
import com.lensyn.usercenter.security.client.system.constants.FeignConstants;
import com.netflix.ribbon.proxy.annotation.Http;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lizhongfu on 14:35 2017/12/18
 * 认证服务器API调用
 */
@FeignClient(name = FeignConstants.USERCENTER_API_NAME, configuration = UserCenterApiFeignConfiguration.class, fallback = ApiserviceImpl.class)
public interface ApiService {

    /**
     * 通过通讯录属性查找通讯录信息
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/enterprise/accounts")
    Response getAddressList(@RequestParam(value = "userName") String userName,
                             @RequestParam(value = "orgName") String orgName,
                             @RequestParam(value = "orgCode") String orgCode,
                             @RequestParam(value = "telephone") String telephone,
                             @RequestParam(value = "email") String email);

    /**
     * 修改一条通讯录信息
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.PATCH, value ="/enterprise/accounts/update")
    Response updateAddressList(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "telephone") String telephone,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "orgName") String orgName,
                               @RequestParam(value = "orgCode") String orgCode,
                               @RequestParam(value = "account") String account);

    /**
     * 获取当前登录用户的信息
     * @return
     */
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    Response me();

    /**
     * 获取当前登录用户的信息
     * @return
     */
    @RequestMapping(value = "/business/accounts/{account}/roles", method = RequestMethod.GET)
    Response getRolesByAccount(@PathVariable("account") String account);

    /**
     * 企业组织树查询
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/enterprise/orgs/tree")
    Response getOrgTree();

}

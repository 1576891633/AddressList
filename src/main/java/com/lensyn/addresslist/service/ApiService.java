package com.lensyn.addresslist.service;

import com.lensyn.addresslist.entity.PageRequest;
import com.lensyn.common.utils.system.response.Response;
import com.lensyn.usercenter.security.client.system.config.UserCenterApiFeignConfiguration;
import com.lensyn.usercenter.security.client.system.constants.FeignConstants;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhongfu on 14:35 2017/12/18
 * 认证服务器API调用
 */
@FeignClient(name = FeignConstants.USERCENTER_API_NAME, configuration = UserCenterApiFeignConfiguration.class, fallback = ApiserviceImpl.class)
public interface ApiService {
    /**
     * 获取通讯录信息
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList" )
    Response addressList();

    /**
     * 通过通讯录属性查找通讯录信息
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/enterprise/accounts")
    Response getAddressList(PageRequest pageRequest);

    /**
     * 修改一条通讯录信息
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.PATCH, value ="/enterprise/accounts/update")
    Response updateAddressList(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "telephone") String telephone,
                               @RequestParam(value = "sex") Integer sex,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "identityCard") String identityCard,
                               @RequestParam(value = "info") String info,
                               @RequestParam(value = "orgCode") Integer enterpriseOrgId,
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
    @RequestMapping(method = RequestMethod.GET, value ="/enterprise/orgs")
    Response getOrgTree();

    /**
     * 获取树形菜单
     *
     * @param clientId 应用ID
     * @return 树形数据
     */
    @RequestMapping(method = RequestMethod.GET, value = "/resources/tree")
    Response getResourcesTree(@RequestParam("clientId") String clientId,
                              @RequestParam("resType") Integer resType);

    @RequestMapping(value = "/enterprise/orgs/{orgCode}/root_tree", method = RequestMethod.GET)
    Response getOrgTreeByOrgCode(@PathVariable(value = "orgCode") String orgCode);

}

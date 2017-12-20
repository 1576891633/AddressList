package com.lensyn.addresslist.service;

import com.lensyn.common.utils.system.response.Response;
import com.lensyn.usercenter.security.client.system.config.UserCenterApiFeignConfiguration;
import com.lensyn.usercenter.security.client.system.constants.FeignConstants;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 通过用户名查找通讯录信息
     * @param userName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{userName}")
    Response getAddressListByUserName(@PathVariable("useName") String userName);

    /**
     * 通过账户名查找通讯录信息
     * @param account
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{account}")
    Response getAddressListByAccount(@PathVariable("account") String account);

    /**
     * 通过组织Code查询通讯录信息
     * @param orgCode
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{orgCode}")
    Response getAddressListByOrgCode(@PathVariable("orgCode") String orgCode);

    /**
     * 通过账户类型获取通讯录信息
     * @param accountType
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{accountType}")
    Response getAddressListByAccountType(@PathVariable("accountType") String accountType);

    /**
     * 通过当前状态获取通讯录信息
     * @param curStatus
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{curStatus}")
    Response getAddressListByCurStatus(@PathVariable("curStatus") String curStatus);

    /**
     * 通过电话号码获取通讯录信息
     * @param telephone
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{telephone}")
    Response getAddressListByTelephone(@PathVariable("telephone") String telephone);

    /**
     * 通过电话号码获取通讯录信息
     * @param identityCard
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{identityCard}")
    Response getAddressListByIdentityCard(@PathVariable("identityCard") String identityCard);

    /**
     * 通过电话职位获取通讯录信息
     * @param position
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{position}")
    Response getAddressListByPosition(@PathVariable("position") String position);

    /**
     * 通过电话号码获取通讯录信息
     * @param email
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="/addressList/{email}")
    Response getAddressListByEmail(@PathVariable("email") String email);

    /**
     * 修改一条通讯录信息
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value ="/addressList/update")
    Response updateAddressList(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "telephone") String telephone,
                               @RequestParam(value = "position") String position,
                               @RequestParam(value = "sex") String sex,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "identityCard") String identityCard,
                               @RequestParam(value = "info") String info,
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
    @RequestMapping(method = RequestMethod.GET, value ="/enterprise/orgs")
    Response getOrgTree();


}

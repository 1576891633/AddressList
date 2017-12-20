package com.lensyn.addresslist.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lensyn.addresslist.domain.UserDto;
import com.lensyn.addresslist.entity.Organization;
import com.lensyn.addresslist.entity.User;
import com.lensyn.usercenter.common.component.dto.user.CurrentUserRolesDto;
import com.lensyn.addresslist.entity.vo.UserVo;
import com.lensyn.addresslist.service.ApiService;
import com.lensyn.usercenter.security.client.service.auth.AuthorizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lensyn.common.utils.system.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lensyn.addresslist.system.util.GsonUtil;


/**
 * Created by lizhongfu on 14:32 2017/12/18
 * 对通讯录相关操作
 */
@Api("对通讯录相关操作接口定义类")
@RestController
/*@RequestMapping("/addressList")*/
public class AddressListController {
    private Logger logger = LoggerFactory.getLogger(AddressListController.class);
    @Autowired
    private ApiService apiService;
    private Gson gson = GsonUtil.getGson();

    /**
     * 获取通讯录信息
     *
     * @return
     */
   /* @ApiOperation(value = "获取通讯录信息", response = UserVo.class)
    @GetMapping(value = "/addressList")
    public Response getAddressList() {
        *//*获取所有通讯录人员*//*
        List<UserDto> addressList = gson.fromJson(gson.toJson(apiService.addressList().getData()), new TypeToken<ArrayList<UserDto>>() {
        }.getType());
        *//*调用接口获取全部组织实体*//*
        List<Organization> organizations = gson.fromJson(gson.toJson(apiService.organization().getData()), new TypeToken<ArrayList<Organization>>() {
        }.getType());
        *//*进行组织编码比对生成组织树*//*
        List<UserVo> userVos = new ArrayList<UserVo>();
        List<UserDto> userDtos = new ArrayList<UserDto>();
        UserVo userVo = new UserVo();
        for (Organization organization : organizations) {
            for (UserDto userDto : addressList) {
                if (organization.getOrgCode().equals(userDto.getOrgCode())) {
                    userDtos.add(userDto);
                }
            }
            userVo.setOrgName(organization.getOrgName());
            userVo.setChildList(userDtos);
            userVos.add(userVo);
            userDtos.clear();
        }

        return new Response().success(userVos);
    }*/

    /**
     * 获取企业组织树
     *
     * @param
     * @return
     */
    @ApiOperation(value = "获取企业组织树，在前端异步加载相关组织通讯录")
    @GetMapping(value = "/enterprise/orgs")
    public Response getOrgTree() {
        Response response = apiService.getOrgTree();
        return response;
    }


    /**
     * 通过用户名查找通讯录信息
     *
     * @param userName
     * @return
     */
    @ApiOperation(value = "通过用户名查找通讯录信息")
    @GetMapping(value = "/addressList/{userName}")
    public Response getAddressListByUserName(@ApiParam(value = "用户名", required = true)
                                             @PathVariable(value = "userName") String userName) {
        return apiService.getAddressListByUserName(userName);
    }

    /**
     * 通过账号查找通讯录信息
     *
     * @param account
     * @return
     */
    @ApiOperation(value = "通过账号查找通讯录信息")
    @GetMapping(value = "/addressList/{account}")
    public Response getAddressListByAccount(@ApiParam(value = "账号", required = true)
                                            @PathVariable(value = "account") String account) {
        return apiService.getAddressListByAccount(account);
    }

    /**
     * 通过组织编码查找通讯录信息
     *
     * @param orgCode
     * @return
     */
    @ApiOperation(value = "通过组织编码查找通讯录信息")
    @GetMapping(value = "/addressList/{orgCode}")
    public Response getAddressListByOrgCode(@ApiParam(value = "账号", required = true)
                                            @PathVariable(value = "orgCode") String orgCode) {
        return apiService.getAddressListByOrgCode(orgCode);
    }

    /**
     * 通过用户账号类型查找通讯录信息
     *
     * @param accountType
     * @return
     */
    @ApiOperation(value = "通过用户账号类型查找通讯录信息")
    @GetMapping(value = "/addressList/{accountType}")
    public Response getAddressListByAccountType(@ApiParam(value = "账号类型", required = true)
                                                @PathVariable(value = "accountType") String accountType) {
        return apiService.getAddressListByAccountType(accountType);
    }

    /**
     * 通过当前状态查找通讯录信息
     *
     * @param curStatus
     * @return
     */
    @ApiOperation(value = "通过当前状态查找通讯录信息")
    @GetMapping(value = "/addressList/{curStatus}")
    public Response getAddressListByCurStatus(@ApiParam(value = "当前状态", required = true)
                                              @PathVariable(value = "curStatus") String curStatus) {
        return apiService.getAddressListByCurStatus(curStatus);
    }

    /**
     * 通过电话号码查找通讯录信息
     *
     * @param telephone
     * @return
     */
    @ApiOperation(value = "通过电话号码查找通讯录信息")
    @GetMapping(value = "/addressList/{telephone}")
    public Response getAddressListByTelephone(@ApiParam(value = "电话号码", required = true)
                                              @PathVariable(value = "telephone") String telephone) {
        return apiService.getAddressListByTelephone(telephone);
    }

    /**
     * 通过身份证号码查找通讯录信息
     *
     * @param identityCard
     * @return
     */
    @ApiOperation(value = "通过身份证号码查找通讯录信息")
    @GetMapping(value = "/addressList/{identityCard}")
    public Response getAddressListByIdentityCard(@ApiParam(value = "电话号码", required = true)
                                                 @PathVariable(value = "identityCard") String identityCard) {
        return apiService.getAddressListByIdentityCard(identityCard);
    }

    /**
     * 通过职位查找通讯录信息
     *
     * @param position
     * @return
     */
    @ApiOperation(value = "通过职位查找通讯录信息")
    @GetMapping(value = "/addressList/{position}")
    public Response getAddressListByPosition(@ApiParam(value = "职位", required = true)
                                             @PathVariable(value = "position") String position) {
        return apiService.getAddressListByPosition(position);
    }

    /**
     * 通过邮件查找通讯录信息
     *
     * @param email
     * @return
     */
    @ApiOperation(value = "通过邮件查找通讯录信息")
    @GetMapping(value = "/addressList/{email}")
    public Response getAddressListByEmail(@ApiParam(value = "邮件", required = true)
                                          @PathVariable(value = "email") String email) {
        return apiService.getAddressListByEmail(email);
    }

    /**
     * 修改通讯录信息
     *
     * @param
     * @return
     */
    @ApiOperation(value = "修改通讯录信息")
    @PutMapping(value = "/addressList/update")
    public Response updateAddressList(@ApiParam(value = "姓名") @PathVariable(value = "userName") String userName,
                                      @ApiParam(value = "电话") @PathVariable(value = "telephone") String telephone,
                                      @ApiParam(value = "职位") @PathVariable(value = "position") String position,
                                      @ApiParam(value = "性别") @PathVariable(value = "sex") String sex,
                                      @ApiParam(value = "邮件") @PathVariable(value = "email") String email,
                                      @ApiParam(value = "身份证") @PathVariable(value = "identityCard") String identityCard,
                                      @ApiParam(value = "详情") @PathVariable(value = "info") String info,
                                      @ApiParam(value = "组织名称") @PathVariable(value = "orgName") String orgName,
                                      @ApiParam(value = "组织编码") @PathVariable(value = "orgCode") String orgCode,
                                      @ApiParam(value = "用户账号，用于sql判断") @PathVariable(value = "account") String account) {

        return apiService.updateAddressList(userName, telephone, position, sex, email, identityCard, info, orgName, orgCode, account);

    }

    /**
     * 获取当前登录用户的角色信息，管理员拥有修改通讯录的权限
     *
     * @param
     * @return
     */
    @ApiOperation(value = "获取角色信息")
    @GetMapping(value = "/me")
    public Response getAddressListRoles() {
        User user = gson.fromJson(gson.toJson(apiService.me().getData()), new TypeToken<User>() {
        }.getType());
        return apiService.getRolesByAccount(user.getAccount());
        /*return response.getMeta().setMessage();*/
    }

}

package com.lensyn.addresslist.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lensyn.addresslist.domain.UserDto;
import com.lensyn.addresslist.entity.PageRequest;
import com.lensyn.addresslist.entity.User;
import com.lensyn.addresslist.entity.vo.OrganizationVo;
import com.lensyn.addresslist.service.ApiService;
import com.lensyn.addresslist.system.util.GsonUtil;
import com.lensyn.common.utils.system.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by lizhongfu on 14:32 2017/12/18
 * 对通讯录相关操作
 */
@Api("对通讯录相关操作接口定义类")
@RestController
/*@RequestMapping("/enterprise/accounts")*/
public class AddressListController {
    private Logger logger = LoggerFactory.getLogger(AddressListController.class);
    @Autowired
    private ApiService apiService;
    private Gson gson = GsonUtil.getGson();

    /**
     * 通过通讯录属性查找通讯录信息
     *
     * @param
     * @return
     */
    @ApiOperation(value = "通过通讯录属性和组织Id查找通讯录信息")
    @GetMapping(value = "/enterprise/accounts")
    public Response getAddressList(@ApiParam(value = "用户名", required = true) @RequestParam(value = "userName") String userName,
                                   @ApiParam(value = "组织名称", required = true) @RequestParam(value = "orgName") String orgName,
                                   @ApiParam(value = "组织Id", required = true) @RequestParam(value = "enterpriseOrgId") String enterpriseOrgId,
                                   @ApiParam(value = "电话号码", required = true) @RequestParam(value = "telephone") String telephone,
                                   @ApiParam(value = "职位", required = true) @RequestParam(value = "position") String position,
                                   @ApiParam(value = "邮件", required = true) @RequestParam(value = "email") String email,
                                   @ApiParam(value = "当前页", required = true) @RequestParam(value = "page") Integer page,
                                   @ApiParam(value = "每页数据量", required = true) @RequestParam(value = "rows") Integer rows) {

        Map<String,String[]> conditions = new HashMap<>();
        String[] userName1 = {userName};
        conditions.put("userName",userName1);
        String[] enterpriseOrgId1 = {enterpriseOrgId};
        conditions.put("enterpriseOrgId",enterpriseOrgId1);
        PageRequest pageRequest = new PageRequest();
        pageRequest.setConditions(conditions);
        pageRequest.setPage(page);
        pageRequest.setRows(rows);

        Response response = apiService.getAddressList(pageRequest);
        return response;
    }

    /**
     * 获取企业组织信息
     *
     * @param
     * @return
     */
    @ApiOperation(value = "获取企业组织，在前端异步加载相关组织通讯录")
    @GetMapping(value = "/enterprise/orgs")
    public Response getOrgTree() {
        Response response = apiService.getOrgTree();
        /*List<OrganizationVo> organizationVos = gson.fromJson(gson.toJson(response.getData()), new TypeToken<ArrayList<OrganizationVo>>() {
        }.getType());
        OrganizationVo organizationVo = buildTree(organizationVos);*/
        return response;
    }

    /**
     * 生成树型结构的json数据
     * @param nodes
     * @return
     */
    public static OrganizationVo buildTree( List<OrganizationVo> nodes) {
        if(null == nodes) {
            return null;
        }
        List<OrganizationVo> topNodes = new ArrayList<>();

        for(OrganizationVo children : nodes){
            String pid = children.getParentCode();
            if (pid == null || "".equals(pid)) {
                topNodes.add(children);

                continue;
            }

            for (OrganizationVo parent : nodes) {
                String id = parent.getOrgCode();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                    continue;
                }
            }
        }
        OrganizationVo root = new OrganizationVo();
        if (topNodes.size() == 1) {
            root = topNodes.get(0);
        } else {
            root.setOrgCode("-1");
            root.setParentCode("");
            root.setChildren(topNodes);
            root.setOrgName("顶级节点");
        }
        return root;
    }

    /**
     * 修改通讯录信息
     *
     * @param
     * @return
     */
    @ApiOperation(value = "修改通讯录信息")
    @PatchMapping(value = "/enterprise/accounts/update")
    public Response updateAddressList(@ApiParam(value = "姓名") @PathVariable(value = "userName") String userName,
                                      @ApiParam(value = "电话") @PathVariable(value = "telephone") String telephone,
                                      @ApiParam(value = "性别") @PathVariable(value = "sex") Integer sex,
                                      @ApiParam(value = "邮件") @PathVariable(value = "email") String email,
                                      @ApiParam(value = "身份证") @PathVariable(value = "identityCard") String identityCard,
                                      @ApiParam(value = "详情") @PathVariable(value = "info") String info,
                                      @ApiParam(value = "组织编码") @PathVariable(value = "orgCode") Integer enterpriseOrgId,
                                      @ApiParam(value = "用户账号，用于sql判断") @PathVariable(value = "account") String account) {

             Response response = apiService.updateAddressList(userName, telephone, sex, email, identityCard, info, enterpriseOrgId, account);
             return response.success("修改通讯录成功");
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

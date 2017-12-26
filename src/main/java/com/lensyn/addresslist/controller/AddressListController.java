package com.lensyn.addresslist.controller;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.lensyn.addresslist.domain.Accounts;
import com.lensyn.addresslist.domain.UserDto;
import com.lensyn.addresslist.entity.User;
import com.lensyn.addresslist.entity.vo.OrganizationVo;
import com.lensyn.addresslist.service.ApiService;
import com.lensyn.addresslist.system.util.ExcelExportUtil;
import com.lensyn.addresslist.system.util.GsonUtil;
import com.lensyn.common.utils.system.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


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
     * 导出excel表格
     * @return
     */
    @ApiOperation(value = "导出excel表格")
    @GetMapping(value = "/excel/export")
    public Response ExportExcel(String userName, String orgName, String orgCode,
                                String telephone, String email, HttpServletResponse httpServletResponse) {

        ExcelExportUtil pee = new ExcelExportUtil("sheet");
        Response response = apiService.getAddressList(userName,orgName,orgCode,telephone,email);
        Object object = response.getData();
        String result = gson.toJson(object);
        Accounts accounts = gson.fromJson(result, Accounts.class);
        List<UserDto> dataList = accounts.getRows();
        String titleColumn[] = {"userName","orgName","telephone","email"};
        String titleName[] = {"用户名","部门","电话","邮箱"};
        int titleSize[] = {13,13,13,13};
        //其他设置 set方法可全不调用
        String colFormula[] = new String[4];
        colFormula[3] = "D@*12";   //设置第4列的公式
        pee.setColFormula(colFormula);
        pee.setAddress("A:D");  //自动筛选
        pee.wirteExcel(titleColumn, titleName, titleSize, dataList, httpServletResponse);
        return new Response().success("导出excel成功");
    }

    /**
     * 通过通讯录属性查找通讯录信息,page和size放在头信息header里面
     *
     * @param
     * @return
     */
    @ApiOperation(value = "通过通讯录属性查找通讯录信息")
    @GetMapping(value = "/enterprise/accounts")
    public Response getAddressList(String userName, String orgName, String orgCode, String telephone, String email) {
        Response response = apiService.getAddressList(userName,orgName,orgCode,telephone,email);
        return response;
    }

    /**
     * 获取企业组织信息
     *
     * @param
     * @return
     */
    @ApiOperation(value = "获取企业组织树，在前端异步加载相关组织通讯录")
    @GetMapping(value = "/enterprise/orgs/tree")
    public Response getOrgTree() {
        Response response = apiService.getOrgTree();
        /*生成Json树形结构*/
        /*List<OrganizationVo> organizationVos = gson.fromJson(gson.toJson(response.getData()), new TypeToken<ArrayList<OrganizationVo>>() {
        }.getType());
        OrganizationVo organizationVo = buildTree(organizationVos);*/
        return response;
    }

    /**
     * 生成树型结构的json数据,暂时没用，返回来就是树形结构了
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
    public Response updateAddressList(@ApiParam(value = "姓名") @RequestParam(value = "userName") String userName,
                                      @ApiParam(value = "电话") @RequestParam(value = "telephone") String telephone,
                                      @ApiParam(value = "邮件") @RequestParam(value = "email") String email,
                                      @ApiParam(value = "组织名称") @RequestParam(value = "orgName") String orgName,
                                      @ApiParam(value = "组织编码") @RequestParam(value = "orgCode") String orgCode,
                                      @ApiParam(value = "用户账号，用于sql判断") @RequestParam(value = "account") String account) {

             Response response = apiService.updateAddressList(userName, telephone, email, orgName, orgCode, account);
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

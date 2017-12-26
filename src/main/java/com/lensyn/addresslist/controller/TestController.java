package com.lensyn.addresslist.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lensyn.addresslist.entity.vo.OrganizationVo;
import com.lensyn.addresslist.service.ApiService;
import com.lensyn.addresslist.system.util.GsonUtil;
import com.lensyn.common.utils.system.response.Response;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
/*@RequestMapping("/resources")*/
@Api("userController相关api")
public class TestController {

    @Autowired
    private ApiService apiService;
    private Gson gson = GsonUtil.getGson();

   /* @ApiOperation(value = "")
    @GetMapping(value = "/enterprise/orgs/{orgCode}/root_tree")
    public Response getOrgTreeByOrgCode(@ApiParam(value = "职位", required = true)
                                             @PathVariable(value = "orgCode") String orgCode) {
        return apiService.getOrgTreeByOrgCode(orgCode);
    }*/

    @ApiOperation(value = "获取企业组织，在前端异步加载相关组织通讯录")
    @PostMapping(value = "/hello")
    public Response getTestBody(OrganizationVo organizationVo) {
        return new Response().success(organizationVo);
    }

}

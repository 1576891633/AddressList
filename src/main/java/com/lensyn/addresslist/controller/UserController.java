package com.lensyn.addresslist.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lensyn.addresslist.service.ApiService;
import com.lensyn.addresslist.system.util.GsonUtil;
import com.lensyn.common.utils.system.response.Response;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lensyn.addresslist.domain.CustomizationsDto;

import java.util.ArrayList;
import java.util.List;

@RestController
/*@RequestMapping("/resources")*/
@Api("userController相关api")
public class UserController {

    @Autowired
    private ApiService apiService;
    private Gson gson = GsonUtil.getGson();

    @ApiOperation("获取用户信息")
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})
    @GetMapping(value = "/resources/tree")
    public Response getUser() {
        Response response = apiService.getResourcesTree("1", 1);
        if (response.getMeta().getCode() != 1) return response;
        List<CustomizationsDto> ChildList = gson.fromJson(gson.toJson(response.getData()), new TypeToken<ArrayList<CustomizationsDto>>() {
        }.getType());
        return new Response().success(ChildList);
    }

    @ApiOperation(value = "")
    @GetMapping(value = "/enterprise/orgs/{orgCode}/root_tree")
    public Response getOrgTreeByOrgCode(@ApiParam(value = "职位", required = true)
                                             @PathVariable(value = "orgCode") String orgCode) {
        return apiService.getOrgTreeByOrgCode(orgCode);
    }

}

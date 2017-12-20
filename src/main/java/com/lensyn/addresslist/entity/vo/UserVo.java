package com.lensyn.addresslist.entity.vo;

import com.lensyn.addresslist.domain.UserDto;

import java.util.List;

/**
 * Created by lizhongfu on 14:07 2017/12/18
 * 返回给前端通讯录以组织树方式呈现
 */
public class UserVo {

    private String orgName;
    private List<UserDto> childList;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<UserDto> getChildList() {
        return childList;
    }

    public void setChildList(List<UserDto> childList) {
        this.childList = childList;
    }
}

package com.lensyn.addresslist.entity;

/**
 * Created by lizhongfu on 10:30 2017/12/19
 * 组织实体
 */
public class Organization {

    private String orgCode;     /*组织编码*/
    private String orgName;     /*组织名称*/

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}

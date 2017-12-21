package com.lensyn.addresslist.entity.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhongfu on 10:30 2017/12/19
 * 组织实体
 */
public class OrganizationVo {

    private String orgCode;     /*组织编码*/
    private String orgName;     /*组织名称*/
    private String parentCode;     /*父节点编码*/
    private List<OrganizationVo> children = new ArrayList<OrganizationVo>();

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

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public List<OrganizationVo> getChildren() {
        return children;
    }

    public void setChildren(List<OrganizationVo> children) {
        this.children = children;
    }

    public OrganizationVo(String orgCode, String parentCode, String orgName) {
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.parentCode = parentCode;
    }

    public OrganizationVo() {
    }
}

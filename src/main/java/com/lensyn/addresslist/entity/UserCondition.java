package com.lensyn.addresslist.entity;

import io.swagger.annotations.ApiParam;

/**
 * Created by lizhongfu on 14:10 2017/12/18
 * 通讯录搜索条件类
 */
public class UserCondition {
    @ApiParam("姓名")
    private String userName;
    @ApiParam("账号")
    private String account;
    @ApiParam("组织code")
    private String orgCode;
    @ApiParam("用户账号类型")
    private String accountType;
    @ApiParam("顺序标号")
    private String indexOrder;
    @ApiParam("当前状态")
    private String curStatus;
    @ApiParam("应用ID")
    private String appId;
    @ApiParam("开始日期")
    private Integer startDate;
    @ApiParam("结束日期")
    private Integer invalidDate;
    @ApiParam("电话")
    private Integer telephone;
    @ApiParam("身份证")
    private Integer identityCard;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getIndexOrder() {
        return indexOrder;
    }

    public void setIndexOrder(String indexOrder) {
        this.indexOrder = indexOrder;
    }

    public String getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(String curStatus) {
        this.curStatus = curStatus;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(Integer invalidDate) {
        this.invalidDate = invalidDate;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(Integer identityCard) {
        this.identityCard = identityCard;
    }
}

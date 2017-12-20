package com.lensyn.addresslist.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by huanghongxi on 2017/5/19.
 * 登录用户信息
 */
@ApiModel(description = "User类")
public class User {

    private String userName;            /*用户名*/
    private String loginName;           /*登录名*/
    private Integer userAccountType;    /*用户账号类型*/
    private String startDate;           /*开始日期*/
    private String invalidDate;         /*过期日期*/
    private Integer sex;                /*性别*/
    @ApiModelProperty(value = "账户名", required = true)
    private String account;             /*账号*/
    private String telephone;           /*电话*/
    private String identityCard;        /*身份证*/
    private String email;               /*邮件*/
    private String info;                /*详情*/
    private Integer curStatus;          /*当前状态*/
    private String roles;               /*角色*/
    private String clientId;            /*oauth2 认证ID*/
    private String callbackUrl;         /*oauth2 回调链接*/
    private String accessUrl;           /*进入链接*/
    private String appName;             /*应用名*/
    private String appCode;             /*应用编码*/
    private String grantType;
    @ApiModelProperty(value = "旧密码", required = true)
    private String oldPwd;              /*旧密码*/
    @ApiModelProperty(value = "新密码", required = true)
    private String newPwd;              /*新密码*/
    private String orgName;             /*组织名称*/
    private String orgCode;             /*组织code*/
    private String orgType;             /*组织信息*/


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(Integer userAccountType) {
        this.userAccountType = userAccountType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getInvalidDate() {
        return invalidDate;
    }

    public void setInvalidDate(String invalidDate) {
        this.invalidDate = invalidDate;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
}

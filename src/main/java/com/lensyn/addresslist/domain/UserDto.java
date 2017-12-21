package com.lensyn.addresslist.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by lizhongfu on 22:17 2017/12/18
 *  封装从资源接口取得的数据
 */
public class UserDto {
    private String userName;         /*姓名*/
    private String telephone;        /*电话*/
    private String position;         /*职位*/
    private Integer sex;             /*性别*/
    private String email;            /*邮件*/
    private String identityCard;     /*身份证*/
    private String info;             /*详情*/
    private String enterpriseOrgId;  /*组织ID*/
    private String account;          /*用户账号，用于更新数据的定位*/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEnterpriseOrgId() {
        return enterpriseOrgId;
    }

    public void setEnterpriseOrgId(String enterpriseOrgId) {
        this.enterpriseOrgId = enterpriseOrgId;
    }
}

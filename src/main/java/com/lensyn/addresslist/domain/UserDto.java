package com.lensyn.addresslist.domain;

/**
 * Created by lizhongfu on 11:40 2017/12/25
 */
public class UserDto {
    private String userName;         /*姓名*/
    private String telephone;        /*电话*/
    private String email;            /*邮箱*/
    private String orgName;          /*组织名称*/

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public UserDto(String userName, String telephone, String email, String orgName) {
        this.userName = userName;
        this.telephone = telephone;
        this.email = email;
        this.orgName = orgName;
    }
}

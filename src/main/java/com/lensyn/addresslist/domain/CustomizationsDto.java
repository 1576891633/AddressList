package com.lensyn.addresslist.domain;


import com.google.gson.annotations.SerializedName;
import com.lensyn.addresslist.entity.Customization;

import java.util.Date;
import java.util.List;

/**
 * Created by huanghongxi on 2017/5/20.
 * 定制信息数据转换对象
 */
public class CustomizationsDto extends Customization {

    private String appName;                     /*应用名称*/
    private Integer curStatus;                  /*当前状态*/
    private String info;                        /*信息*/
    private Date operationDate;                 /*操作日期*/
    private String oauthClientId;               /*认证客户端ID*/
    private String oauthClientSecret;           /*认证客户端密钥*/
    private String oauthCallBack;               /*回调地址*/
    private String accessUrl;                   /*进入链接*/
    private String icon;                        /*图标样式*/
    private String resName;                     /*资源名称*/
    private Integer resType;                    /*资源类型*/
    private boolean isMenuLeaf;                 /*是否是叶子节点*/
    private String url;                         /*跳转地址*/
    @SerializedName("children")
    private List<CustomizationsDto> childList;  /*功能包的子集*/

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getOauthClientId() {
        return oauthClientId;
    }

    public void setOauthClientId(String oauthClientId) {
        this.oauthClientId = oauthClientId;
    }

    public String getOauthClientSecret() {
        return oauthClientSecret;
    }

    public void setOauthClientSecret(String oauthClientSecret) {
        this.oauthClientSecret = oauthClientSecret;
    }

    public String getOauthCallBack() {
        return oauthCallBack;
    }

    public void setOauthCallBack(String oauthCallBack) {
        this.oauthCallBack = oauthCallBack;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public Integer getResType() {
        return resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }

    public boolean getIsMenuLeaf() {
        return isMenuLeaf;
    }

    public void setIsMenuLeaf(boolean isMenuLeaf) {
        this.isMenuLeaf = isMenuLeaf;
    }

    public List<CustomizationsDto> getChildList() {
        return childList;
    }

    public void setChildList(List<CustomizationsDto> childList) {
        this.childList = childList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CustomizationsDto{" +
                "appName='" + appName + '\'' +
                ", curStatus=" + curStatus +
                ", info='" + info + '\'' +
                ", operationDate=" + operationDate +
                ", oauthClientId='" + oauthClientId + '\'' +
                ", oauthClientSecret='" + oauthClientSecret + '\'' +
                ", oauthCallBack='" + oauthCallBack + '\'' +
                ", accessUrl='" + accessUrl + '\'' +
                ", icon='" + icon + '\'' +
                ", resName='" + resName + '\'' +
                ", resType=" + resType +
                ", isMenuLeaf=" + isMenuLeaf +
                ", url='" + url + '\'' +
                ", childList=" + childList +
                '}';
    }
}

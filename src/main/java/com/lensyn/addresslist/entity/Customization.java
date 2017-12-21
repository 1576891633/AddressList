package com.lensyn.addresslist.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


/**
 * Created by huanghongxi on 2017/5/19.
 * 定制信息
 */
@ApiModel
public class Customization {

    public static final Integer APP = 0;            /*应用类型*/
    public static final Integer FUNCTION = 1;       /*功能类型*/
    public static final Integer PACKAGE = 2;        /*功能包*/
    public static final Integer ACTIVE = 0;         /*激活*/
    public static final Integer NONACTIVATED = 1;   /*未激活*/
    @ApiModelProperty("定制信息ID,一个资源对应一个ID")
    @NotEmpty(message = "定制ID不能为空")
    private String customizationId;                 /*定制ID*/
    @ApiModelProperty(value = "用户ID", required = true)
    @NotEmpty(message = "用户ID不能为空")
    private String userId;                          /*用户ID*/
    @ApiModelProperty("资源编码")
    private String resCode;                         /*资源编码*/
    @ApiModelProperty("应用编码")
    private String appCode;                         /*应用编码*/
    @ApiModelProperty(value = "顺序编号", required = true)
    @NotNull(message = "顺序编号不能为空")
    private Integer index;                          /*顺序编号*/
    @ApiModelProperty(value = "状态(0:启用，1:隐藏)", required = true)
    @NotNull(message = "激活状态不能为空")
    private Integer activeStatus;                   /*状态(0:启用，1:隐藏)*/
    @ApiModelProperty(value = "类型(0:应用,1:功能,2:功能包)", required = true)
    @NotNull(message = "资源类型不能为空")
    private Integer resourceType;                   /*类型(0:应用,1:功能,2:功能包)*/
    @ApiModelProperty("资源的直接父所属")
    private String parentCode;                      /*资源的直接父所属*/
    @ApiModelProperty("资源的直接父所属名称")
    private String parentName;                      /*资源的直接父所属名称*/
    @ApiModelProperty("属于某个功能包")
//    @SerializedName("parentCode")
    private String parentId;                        /*属于某个功能包*/
    @ApiModelProperty("功能包名称")
    private String packageName;                     /*功能包名称*/

    public String getCustomizationId() {
        return customizationId;
    }

    public void setCustomizationId(String customizationId) {
        this.customizationId = customizationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "Customization{" +
                "customizationId='" + customizationId + '\'' +
                ", userId='" + userId + '\'' +
                ", resCode='" + resCode + '\'' +
                ", appCode='" + appCode + '\'' +
                ", index=" + index +
                ", activeStatus=" + activeStatus +
                ", resourceType=" + resourceType +
                ", parentId='" + parentId + '\'' +
                ", packageName='" + packageName + '\'' +
                '}';
    }
}

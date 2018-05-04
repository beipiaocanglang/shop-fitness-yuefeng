package com.bizcloud.memberdecoration.modal.fitness;



import java.io.Serializable;
import java.util.Date;

/**
 * Created by dev on 2017/4/18.
 */
public class MemberPageVO  implements Serializable{
    private Long id;

    private String pageType;

    private String memberId;

    private Long templateId;

    private Date addTime;

    private Date modifyTime;

    private String platformId;

    private String shopId;

    private String pageName;

    private String pageKeyname;

    private Byte onlineStatus;

    public Byte getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Byte onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageKeyname() {
        return pageKeyname;
    }

    public void setPageKeyname(String pageKeyname) {
        this.pageKeyname = pageKeyname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public SystemTemplate getSystemTemplate() {
        return systemTemplate;
    }

    public void setSystemTemplate(SystemTemplate systemTemplate) {
        this.systemTemplate = systemTemplate;
    }

    private SystemTemplate systemTemplate;

}

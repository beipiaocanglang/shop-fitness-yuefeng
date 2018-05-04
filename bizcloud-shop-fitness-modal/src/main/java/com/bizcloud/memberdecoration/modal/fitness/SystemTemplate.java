package com.bizcloud.memberdecoration.modal.fitness;

import java.io.Serializable;

public class SystemTemplate  implements Serializable{
    private Long id;

    private String name;

    private String url;

    private String realname;

    private String previewPic;

    private Integer templateType;

    private String orgTemplateUrl;

    private String templateUrl;

    private Integer tempStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPreviewPic() {
        return previewPic;
    }

    public void setPreviewPic(String previewPic) {
        this.previewPic = previewPic == null ? null : previewPic.trim();
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public String getOrgTemplateUrl() {
        return orgTemplateUrl;
    }

    public void setOrgTemplateUrl(String orgTemplateUrl) {
        this.orgTemplateUrl = orgTemplateUrl == null ? null : orgTemplateUrl.trim();
    }

    public String getTemplateUrl() {
        return templateUrl;
    }

    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl == null ? null : templateUrl.trim();
    }

    public Integer getTempStatus() {
        return tempStatus;
    }

    public void setTempStatus(Integer tempStatus) {
        this.tempStatus = tempStatus;
    }
}
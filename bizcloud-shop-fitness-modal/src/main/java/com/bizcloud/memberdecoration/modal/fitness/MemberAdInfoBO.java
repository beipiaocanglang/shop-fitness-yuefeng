package com.bizcloud.memberdecoration.modal.fitness;

import com.bizcloud.framework.base.BaseBO;

import java.io.Serializable;

/**
 * Created by dev on 2017/5/8.
 */
public class MemberAdInfoBO  implements Serializable{
    private Long id;

    private String name;

    private Long pageId;

    private Long moduleId;

    private String keyname;

    private String titleContext;

    private String titleUrl;

    private String titlePic;

    private String moreContext;

    private String moreUrl;

    private String morePic;

    private String otherContext;

    private String otherUrl;

    private String otherPic;

    private String moduleSignname;

    private String context;

    private String param;

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

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname == null ? null : keyname.trim();
    }

    public String getTitleContext() {
        return titleContext;
    }

    public void setTitleContext(String titleContext) {
        this.titleContext = titleContext == null ? null : titleContext.trim();
    }

    public String getTitleUrl() {
        return titleUrl;
    }

    public void setTitleUrl(String titleUrl) {
        this.titleUrl = titleUrl == null ? null : titleUrl.trim();
    }

    public String getTitlePic() {
        return titlePic;
    }

    public void setTitlePic(String titlePic) {
        this.titlePic = titlePic == null ? null : titlePic.trim();
    }

    public String getMoreContext() {
        return moreContext;
    }

    public void setMoreContext(String moreContext) {
        this.moreContext = moreContext == null ? null : moreContext.trim();
    }

    public String getMoreUrl() {
        return moreUrl;
    }

    public void setMoreUrl(String moreUrl) {
        this.moreUrl = moreUrl == null ? null : moreUrl.trim();
    }

    public String getMorePic() {
        return morePic;
    }

    public void setMorePic(String morePic) {
        this.morePic = morePic == null ? null : morePic.trim();
    }

    public String getOtherContext() {
        return otherContext;
    }

    public void setOtherContext(String otherContext) {
        this.otherContext = otherContext == null ? null : otherContext.trim();
    }

    public String getOtherUrl() {
        return otherUrl;
    }

    public void setOtherUrl(String otherUrl) {
        this.otherUrl = otherUrl == null ? null : otherUrl.trim();
    }

    public String getOtherPic() {
        return otherPic;
    }

    public void setOtherPic(String otherPic) {
        this.otherPic = otherPic == null ? null : otherPic.trim();
    }

    public String getModuleSignname() {
        return moduleSignname;
    }

    public void setModuleSignname(String moduleSignname) {
        this.moduleSignname = moduleSignname == null ? null : moduleSignname.trim();
    }


    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }
}

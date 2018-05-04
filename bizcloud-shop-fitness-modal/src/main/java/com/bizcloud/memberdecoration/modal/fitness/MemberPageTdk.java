package com.bizcloud.memberdecoration.modal.fitness;

import java.io.Serializable;

/**
 * Created by dev on 2017/7/10.
 */
public class MemberPageTdk implements Serializable {

    private Long id;

    private Long memberPageId;

    private String memberPageTitle;

    private String memberPageKey;

    private String memberPageDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberPageId() {
        return memberPageId;
    }

    public void setMemberPageId(Long memberPageId) {
        this.memberPageId = memberPageId;
    }

    public String getMemberPageTitle() {
        return memberPageTitle;
    }

    public void setMemberPageTitle(String memberPageTitle) {
        this.memberPageTitle = memberPageTitle == null ? null : memberPageTitle.trim();
    }

    public String getMemberPageKey() {
        return memberPageKey;
    }

    public void setMemberPageKey(String memberPageKey) {
        this.memberPageKey = memberPageKey == null ? null : memberPageKey.trim();
    }

    public String getMemberPageDescription() {
        return memberPageDescription;
    }

    public void setMemberPageDescription(String memberPageDescription) {
        this.memberPageDescription = memberPageDescription == null ? null : memberPageDescription.trim();
    }

}

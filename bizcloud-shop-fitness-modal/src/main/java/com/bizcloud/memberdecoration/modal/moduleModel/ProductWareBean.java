package com.bizcloud.memberdecoration.modal.moduleModel;

import com.bizcloud.open.api.ware.client.dto.Ware;

/**
 * Created by dev on 2017/4/18.
 */
public class ProductWareBean {

    //自定义图片地址
    private  String picUrl;

    //主图地址
    private String mainPicUrl;
    //首个skuid
    private String skuid;
    //ware
    private Ware ware;


    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMainPicUrl() {
        return mainPicUrl;
    }

    public void setMainPicUrl(String mainPicUrl) {
        this.mainPicUrl = mainPicUrl;
    }

    public String getSkuid() {
        return skuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = skuid;
    }

    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }

    public ProductWareBean() {
    }





}

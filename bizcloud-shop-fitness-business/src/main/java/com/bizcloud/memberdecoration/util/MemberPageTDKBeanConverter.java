package com.bizcloud.memberdecoration.util;

import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageTdkDTO;
import com.bizcloud.memberdecoration.modal.fitness.MemberPageTdk;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 2017/7/10.
 */
public class MemberPageTDKBeanConverter {

    private static Logger LOG = LoggerFactory.getLogger(FitmentMMBeanConverter.class);

    private static Gson gson = new Gson();
    //用户模块转换
    public static MemberPageTdk mptDTOtoMpt(MemberPageTdkDTO dto){
        MemberPageTdk memberPageTdk = new MemberPageTdk();
        try {
            BeanUtils.copyProperties(dto, memberPageTdk);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(dto), e.getMessage());
        }
        return memberPageTdk;
    }
    //用户模块转换
    public static MemberPageTdkDTO mpttoMptDTO(MemberPageTdk memberPageTdk){
        MemberPageTdkDTO dto = new MemberPageTdkDTO();
        try {
            BeanUtils.copyProperties(memberPageTdk, dto);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(memberPageTdk), e.getMessage());
        }
        return dto;
    }
    //用户页面转换
    public static List<MemberPageTdkDTO> mptlisttomptDTOlist(List<MemberPageTdk> mptlist){
        List<MemberPageTdkDTO> dtolist = new ArrayList<>();
        for (MemberPageTdk mm : mptlist){
            dtolist.add(mpttoMptDTO(mm));
        }
        return dtolist;
    }
    //用户页面转换
    public static List<MemberPageTdk> mptDTOlisttomptlist(List<MemberPageTdkDTO> dtolist){
        List<MemberPageTdk> mmlist = new ArrayList<>();
        for (MemberPageTdkDTO dto : dtolist){
            mmlist.add(mptDTOtoMpt(dto));
        }
        return mmlist;
    }
}

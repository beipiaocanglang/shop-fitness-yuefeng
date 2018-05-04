package com.bizcloud.memberdecoration.util;

import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageDTO;
import com.bizcloud.memberdecoration.dto.fitness.SystemModuleDTO;
import com.bizcloud.memberdecoration.modal.fitness.MemberPage;
import com.bizcloud.memberdecoration.modal.fitness.SystemModule;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dev on 2017/5/27.
 */
public class FitmentMPBeanConverter {

    private static Logger LOG = LoggerFactory.getLogger(FitmentMPBeanConverter.class);

    private static Gson gson = new Gson();
    //用户页面转换
    public static MemberPage mpDTOtoMp(MemberPageDTO dto){
        MemberPage memberPage = new MemberPage();
        try {
            BeanUtils.copyProperties(dto, memberPage);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(dto), e.getMessage());
        }
        return memberPage;
    }
    //用户页面转换
    public static MemberPageDTO mptompDTO(MemberPage mp){
        MemberPageDTO dto = new MemberPageDTO();
        try {
            BeanUtils.copyProperties(mp, dto);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(mp), e.getMessage());
        }
        return dto;
    }
    //用户页面转换
    public static List<MemberPageDTO> mplisttompDTOlist(List<MemberPage> mplist){
        List<MemberPageDTO> dtolist = new ArrayList<MemberPageDTO>();
        for (MemberPage mp : mplist){
            dtolist.add(mptompDTO(mp));
        }
        return dtolist;
    }
    //用户页面转换
    public static List<MemberPage> smDTOlisttosmlist(List<MemberPageDTO> mpdtolist){
        List<MemberPage> mplist = new ArrayList<MemberPage>();
        for (MemberPageDTO dto : mpdtolist){
            mplist.add(mpDTOtoMp(dto));
        }
        return mplist;
    }


}

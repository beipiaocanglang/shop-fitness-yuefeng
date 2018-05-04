package com.bizcloud.memberdecoration.util;

import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.dto.fitness.MemberAdInfoBODTO;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageVODTO;
import com.bizcloud.memberdecoration.modal.fitness.MemberAdInfoBO;
import com.bizcloud.memberdecoration.modal.fitness.MemberPageVO;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dev on 2017/5/27.
 */
public class FitmentMPMBBeanConverter {

    private static Logger LOG = LoggerFactory.getLogger(FitmentMPMBBeanConverter.class);

    private static Gson gson = new Gson();
    //用户模块转换
    public static MemberPageVO mpvDTOtoMpv(MemberPageVODTO dto){
        MemberPageVO memberPageVO = new MemberPageVO();
        try {
            BeanUtils.copyProperties(dto, memberPageVO);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(dto), e.getMessage());
        }
        return memberPageVO;
    }
    //用户模块转换
    public static MemberPageVODTO mpvtompvDTO(MemberPageVO mpv){
        MemberPageVODTO dto = new MemberPageVODTO();
        try {
            BeanUtils.copyProperties(mpv, dto);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(mpv), e.getMessage());
        }
        return dto;
    }
    //用户页面转换
    public static List<MemberPageVODTO> mmlisttommDTOlist(List<MemberPageVO> mmlist){
        List<MemberPageVODTO> dtolist = new ArrayList<MemberPageVODTO>();
        for (MemberPageVO mm : mmlist){
            dtolist.add(mpvtompvDTO(mm));
        }
        return dtolist;
    }
    //用户页面转换
    public static List<MemberPageVO> smDTOlisttosmlist(List<MemberPageVODTO> mmdtolist){
        List<MemberPageVO> mmlist = new ArrayList<MemberPageVO>();
        for (MemberPageVODTO dto : mmdtolist){
            mmlist.add(mpvDTOtoMpv(dto));
        }
        return mmlist;
    }


}

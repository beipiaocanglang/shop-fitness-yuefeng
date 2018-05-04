package com.bizcloud.memberdecoration.util;

import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.dto.fitness.MemberAdInfoBODTO;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageDTO;
import com.bizcloud.memberdecoration.modal.fitness.MemberAdInfoBO;
import com.bizcloud.memberdecoration.modal.fitness.MemberPage;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dev on 2017/5/27.
 */
public class FitmentMMBeanConverter {

    private static Logger LOG = LoggerFactory.getLogger(FitmentMMBeanConverter.class);

    private static Gson gson = new Gson();
    //用户模块转换
    public static MemberAdInfoBO mmDTOtoMm(MemberAdInfoBODTO dto){
        MemberAdInfoBO memberAdInfoBO = new MemberAdInfoBO();
        try {
            BeanUtils.copyProperties(dto, memberAdInfoBO);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(dto), e.getMessage());
        }
        return memberAdInfoBO;
    }
    //用户模块转换
    public static MemberAdInfoBODTO mmtommDTO(MemberAdInfoBO mm){
        MemberAdInfoBODTO dto = new MemberAdInfoBODTO();
        try {
            BeanUtils.copyProperties(mm, dto);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(mm), e.getMessage());
        }
        return dto;
    }
    //用户页面转换
    public static List<MemberAdInfoBODTO> mmlisttommDTOlist(List<MemberAdInfoBO> mmlist){
        List<MemberAdInfoBODTO> dtolist = new ArrayList<MemberAdInfoBODTO>();
        for (MemberAdInfoBO mm : mmlist){
            dtolist.add(mmtommDTO(mm));
        }
        return dtolist;
    }
    //用户页面转换
    public static List<MemberAdInfoBO> smDTOlisttosmlist(List<MemberAdInfoBODTO> mmdtolist){
        List<MemberAdInfoBO> mmlist = new ArrayList<MemberAdInfoBO>();
        for (MemberAdInfoBODTO dto : mmdtolist){
            mmlist.add(mmDTOtoMm(dto));
        }
        return mmlist;
    }


}

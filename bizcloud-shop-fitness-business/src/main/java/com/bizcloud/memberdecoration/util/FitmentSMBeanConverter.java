package com.bizcloud.memberdecoration.util;

import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.dto.fitness.SystemModuleDTO;
import com.bizcloud.memberdecoration.dto.fitness.SystemTemplateDTO;
import com.bizcloud.memberdecoration.modal.fitness.SystemModule;
import com.bizcloud.memberdecoration.modal.fitness.SystemTemplate;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dev on 2017/5/27.
 */
public class FitmentSMBeanConverter {

    private static Logger LOG = LoggerFactory.getLogger(FitmentSMBeanConverter.class);

    private static Gson gson = new Gson();
    //系统模块转换
    public static SystemModule smDTOtoSm(SystemModuleDTO dto){
        SystemModule systemModule = new SystemModule();
        try {
            BeanUtils.copyProperties(dto, systemModule);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(dto), e.getMessage());
        }
        return systemModule;
    }
    //系统模版转换
    public static SystemModuleDTO smtoSmDTO(SystemModule sm){
        SystemModuleDTO dto = new SystemModuleDTO();
        try {
            BeanUtils.copyProperties(sm, dto);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(sm), e.getMessage());
        }
        return dto;
    }
    //系统模版转换
    public static List<SystemModuleDTO> smlisttoSmDTOlist(List<SystemModule> smlist){
        List<SystemModuleDTO> dtolist = new ArrayList<SystemModuleDTO>();
        for (SystemModule sm : smlist){
            dtolist.add(smtoSmDTO(sm));
        }
        return dtolist;
    }
    //系统模版转换
    public static List<SystemModule> smDTOlisttosmlist(List<SystemModuleDTO> smdtolist){
        List<SystemModule> smlist = new ArrayList<SystemModule>();
        for (SystemModuleDTO dto : smdtolist){
            smlist.add(smDTOtoSm(dto));
        }
        return smlist;
    }


}

package com.bizcloud.memberdecoration.util;

import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.dto.fitness.SystemTemplateDTO;
import com.bizcloud.memberdecoration.modal.fitness.SystemTemplate;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dev on 2017/5/27.
 */
public class FitmentSTBeanConverter {

    private static Logger LOG = LoggerFactory.getLogger(FitmentSTBeanConverter.class);

    private static Gson gson = new Gson();
    //系统模版转换
    public static SystemTemplate stDTOtoSt(SystemTemplateDTO dto){
        SystemTemplate systemTemplate = new SystemTemplate();
        try {
            BeanUtils.copyProperties(dto, systemTemplate);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(dto), e.getMessage());
        }
        return systemTemplate;
    }
    //系统模版转换
    public static SystemTemplateDTO sttoStDTO(SystemTemplate st){
        SystemTemplateDTO dto = new SystemTemplateDTO();
        try {
            BeanUtils.copyProperties(st, dto);
        } catch (BeansException e) {
            LOG.error("GroupBuyingDTO To GroupBuyingBO BeansException!, groupBuyingDTO:{}, errorMsg:{}",
                    gson.toJson(st), e.getMessage());
        }
        return dto;
    }
    //系统模版转换
    public static List<SystemTemplateDTO> stlisttoStDTOlist(List<SystemTemplate> stlist){
        List<SystemTemplateDTO> dtolist = new ArrayList<SystemTemplateDTO>();
        for (SystemTemplate st : stlist){
            dtolist.add(sttoStDTO(st));
        }
        return dtolist;
    }
    //系统模版转换
    public static List<SystemTemplate> stDTOtostlist(List<SystemTemplateDTO> stdtolist){
        List<SystemTemplate> stlist = new ArrayList<SystemTemplate>();
        for (SystemTemplateDTO dto : stdtolist){
            stlist.add(stDTOtoSt(dto));
        }
        return stlist;
    }


}

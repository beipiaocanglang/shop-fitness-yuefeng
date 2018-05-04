package com.bizcloud.memberdecoration.client;


import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.memberdecoration.dto.fitness.SystemModuleDTO;
import com.bizcloud.memberdecoration.dto.fitness.SystemTemplateDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface SystemTempModuleClient {

    ResultDTO<PageInfo<SystemTemplateDTO>> getSystemTemplatePage(int pageNum, int pageSize, Map<String, Object> map);

    ResultDTO<PageInfo<SystemTemplateDTO>> getSystemTemplatePages(int pageNum, int pageSize);

    ResultDTO<List<SystemTemplateDTO>> getSystemTemplateList(int pageNum, int pageSize);

    ResultDTO<List<SystemTemplateDTO>> getAllSystemTemplateList();

    ResultDTO<Boolean> insertSystemTemplate(SystemTemplateDTO dto);

    ResultDTO<Boolean> deleteSystemTemplate(long id);

    ResultDTO<Boolean> updateSystemTemplate(SystemTemplateDTO dto);

    ResultDTO<SystemTemplateDTO> getSystemTemplateById(Long id);

    //systemModule部分
    ResultDTO<PageInfo<SystemModuleDTO>> getSystemModulePage(int pageNum, int pageSize, Map<String, Object> map);

    ResultDTO<List<SystemModuleDTO>> getAllSystemModuleList();

    ResultDTO<Boolean> insertSystemModule(SystemModuleDTO dto);

    ResultDTO<Boolean> deleteSystemModule(long id);

    ResultDTO<Boolean> updateSystemModule(SystemModuleDTO dto);

    ResultDTO<SystemModuleDTO> getSystemModule(Long id);

    ResultDTO<SystemModuleDTO> selectBySignname(String signname);
}

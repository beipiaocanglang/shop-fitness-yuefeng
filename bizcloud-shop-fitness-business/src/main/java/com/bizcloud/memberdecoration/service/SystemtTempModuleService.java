package com.bizcloud.memberdecoration.service;


import com.bizcloud.memberdecoration.modal.fitness.SystemModule;
import com.bizcloud.memberdecoration.modal.fitness.SystemTemplate;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface SystemtTempModuleService {

    //systemTemplate部分

    PageInfo<SystemTemplate> getSystemTemplatePage(int pageNum, int pageSize, Map<String, Object> map);

    PageInfo<SystemTemplate> getSystemTemplatePages(int pageNum, int pageSize);

    List<SystemTemplate> getSystemTemplateList(int pageNum, int pageSize);

    List<SystemTemplate> getAllSystemTemplateList();

    boolean insertSystemTemplate(SystemTemplate systemTemplate);

    boolean deleteSystemTemplate(long id);

    boolean updateSystemTemplate(SystemTemplate systemTemplate);

    SystemTemplate getSystemTemplateById(Long id);

    //systemModule部分
    PageInfo<SystemModule> getSystemModulePage(int pageNum, int pageSize, Map<String, Object> map);

    List<SystemModule> getAllSystemModuleList();

    boolean insertSystemModule(SystemModule systemTemplate);

    boolean deleteSystemModule(long id);

    boolean updateSystemModule(SystemModule systemTemplate);

    SystemModule getSystemModule(Long id);


    SystemModule selectBySignname(String signname);
}

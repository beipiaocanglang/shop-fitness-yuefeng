package com.bizcloud.memberdecoration.service.impl;


import com.bizcloud.memberdecoration.dao.memberadinfo.MemberAdInfoReleaseMapper;
import com.bizcloud.memberdecoration.dao.systemmodule.SystemModuleMapper;
import com.bizcloud.memberdecoration.dao.systemtemplate.SystemTemplateMapper;
import com.bizcloud.memberdecoration.modal.fitness.SystemModule;
import com.bizcloud.memberdecoration.modal.fitness.SystemTemplate;
import com.bizcloud.memberdecoration.service.SystemtTempModuleService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("SystemtTempModuleService")
public class SystemtTempModuleServiceImpl implements SystemtTempModuleService {


    @Resource
    private SystemTemplateMapper systemTemplateMapper;
    @Resource
    private SystemModuleMapper systemModuleMapper;

    @Resource
    private MemberAdInfoReleaseMapper memberAdInfoReleaseMapper;


    //template
    @Override
    public PageInfo<SystemTemplate> getSystemTemplatePage(int pageNum, int pageSize, Map<String, Object> param) {

        return systemTemplateMapper.getSystemTemplatePage(param, new RowBounds(pageNum, pageSize));
    }


    @Override
    public List<SystemTemplate> getSystemTemplateList(int pageNum, int pageSize) {
        return systemTemplateMapper.getAllSystemTemplateList();
    }

    @Override
    public PageInfo<SystemTemplate> getSystemTemplatePages(int pageNum, int pageSize) {
        PageInfo<SystemTemplate> list = new PageInfo<SystemTemplate>();
        try {
            list.setList(systemTemplateMapper.getSystemTemplatePages(new RowBounds(pageNum, pageSize)));
            list.setTotal(systemTemplateMapper.getAllSystemTemplateList().size());
            list.setPageSize(pageSize);
            list.setPageNum(pageNum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    @Override
    public List<SystemTemplate> getAllSystemTemplateList() {
        return systemTemplateMapper.getAllSystemTemplateList();
    }

    @Override
    public boolean insertSystemTemplate(SystemTemplate systemTemplate) {
        return systemTemplateMapper.insertSelective(systemTemplate) > 0;
    }

    @Override
    public boolean deleteSystemTemplate(long id) {
        return systemTemplateMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean updateSystemTemplate(SystemTemplate systemTemplate) {
        return systemTemplateMapper.updateByPrimaryKeySelective(systemTemplate) > 0;
    }


    //module
    @Override
    public PageInfo<SystemModule> getSystemModulePage(int pageNum, int pageSize, Map<String, Object> map) {
        return systemModuleMapper.getSystemModulePage(pageNum, pageSize, map);
    }

    @Override
    public List<SystemModule> getAllSystemModuleList() {
        return systemModuleMapper.getAllSystemModuleList();
    }

    @Override
    public boolean insertSystemModule(SystemModule systemModule) {
        return systemModuleMapper.insertSelective(systemModule) > 0;
    }

    @Override
    public boolean deleteSystemModule(long id) {
        return false;
    }

    @Override
    public boolean updateSystemModule(SystemModule systemModule) {
        return systemModuleMapper.updateByPrimaryKeySelective(systemModule) > 0;
    }

    @Override
    public SystemTemplate getSystemTemplateById(Long id) {
        return systemTemplateMapper.selectByPrimaryKey(id);
    }


    @Override
    public SystemModule getSystemModule(Long id) {
        return systemModuleMapper.selectByPrimaryKey(id);
    }


    @Override
    public SystemModule selectBySignname(String signname) {
        return systemModuleMapper.selectBySignname(signname);
    }
}

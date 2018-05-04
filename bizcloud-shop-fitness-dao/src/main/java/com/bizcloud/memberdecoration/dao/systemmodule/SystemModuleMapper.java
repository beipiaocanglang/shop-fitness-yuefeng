package com.bizcloud.memberdecoration.dao.systemmodule;


import com.bizcloud.memberdecoration.modal.fitness.SystemModule;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface SystemModuleMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SystemModule record);

    SystemModule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemModule record);

    PageInfo<SystemModule> getSystemModulePage(int pageNum, int pageSize, Map<String, Object> map);

    List<SystemModule> getAllSystemModuleList();

    SystemModule selectBySignname(@Param("signname") String signname);

}
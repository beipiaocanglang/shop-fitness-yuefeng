package com.bizcloud.memberdecoration.dao.systemtemplate;



import com.bizcloud.memberdecoration.modal.fitness.SystemTemplate;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface SystemTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(SystemTemplate record);

    SystemTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemTemplate record);

    PageInfo<SystemTemplate> getSystemTemplatePage(@Param("param") Map<String, Object> param, RowBounds rowBounds);

    List<SystemTemplate> getSystemTemplatePages(RowBounds rowBounds);

    List<SystemTemplate> getAllSystemTemplateList();

}
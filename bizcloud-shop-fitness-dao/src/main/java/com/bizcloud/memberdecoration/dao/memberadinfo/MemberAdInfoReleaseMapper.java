package com.bizcloud.memberdecoration.dao.memberadinfo;


import com.bizcloud.memberdecoration.modal.fitness.MemberAdInfoBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dev on 2017/5/8.
 */
@Repository
public interface MemberAdInfoReleaseMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(MemberAdInfoBO record);

    MemberAdInfoBO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberAdInfoBO record);

    MemberAdInfoBO getMemberAdInfoBOByPageIdKeyName(@Param("pageId") Long pageId, @Param("keyname") String keyname);

    List<MemberAdInfoBO> getMemberAdInfoBOListByPageId(@Param("pageId") Long pageId);
}

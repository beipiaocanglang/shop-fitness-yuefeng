package com.bizcloud.memberdecoration.dao.memberpage;


import com.bizcloud.memberdecoration.modal.fitness.MemberPage;
import com.bizcloud.memberdecoration.modal.fitness.MemberPageVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberPageMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(MemberPage record);

    MemberPage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberPage record);

    List<MemberPageVO> getMemberPageByParam(@Param("param") Map<String, Object> param);

    Page<MemberPage> getMemberPageByTypeParam(@Param("param") Map<String, Object> param, RowBounds rowBounds);

    int updateMemberPagesOnlineStatusByParam(@Param("onlineStatus")int onlineStatus,@Param("pageType")int pageType,@Param("shopId")String shopId,@Param("platformId")String platformId);
}
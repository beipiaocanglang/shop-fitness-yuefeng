package com.bizcloud.memberdecoration.dao.memberpagetdk;

import com.bizcloud.memberdecoration.modal.fitness.MemberPageTdk;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by dev on 2017/7/10.
 */
@Repository
public interface MemberPageTdkMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(MemberPageTdk record);

    MemberPageTdk selectByPrimaryKey(Long id);

    MemberPageTdk selectByMemberPageId(@Param("memberPageId") Long memberPageId);

    int updateByPrimaryKeySelective(MemberPageTdk record);

}

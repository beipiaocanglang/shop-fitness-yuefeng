package com.bizcloud.memberdecoration.client;

import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageTdkDTO;

/**
 * Created by dev on 2017/7/10.
 */
public interface MemberPageTdkClient {

    ResultDTO<Boolean> deleteByPrimaryKey(Long id);

    ResultDTO<Boolean> insertSelective(MemberPageTdkDTO record);

    ResultDTO<MemberPageTdkDTO> selectByPrimaryKey(Long id);

    ResultDTO<Boolean> updateByPrimaryKeySelective(MemberPageTdkDTO record);

    ResultDTO<MemberPageTdkDTO> selectByMemberPageId(Long memberPageId);
}

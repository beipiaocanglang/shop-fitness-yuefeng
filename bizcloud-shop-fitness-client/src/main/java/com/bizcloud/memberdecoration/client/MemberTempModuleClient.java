package com.bizcloud.memberdecoration.client;

import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.memberdecoration.dto.fitness.MemberAdInfoBODTO;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageDTO;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageVODTO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface MemberTempModuleClient {
    ResultDTO<Boolean> deleteMemberPageByMemberPageId(Long id);

    ResultDTO<MemberPageDTO> insertSelectiveMemberPage(MemberPageDTO record);

    ResultDTO<MemberPageDTO> selectMemberPageByMemberPageId(Long id);

    ResultDTO<Boolean> updateMemberPageByPrimaryKeySelective(MemberPageDTO record);

    ResultDTO<List<MemberPageVODTO>> getMemberPageByParam(String shopId, String platformId);

    ResultDTO<PageInfo<MemberPageDTO>> getMemberPageByTypeParam(Map<String, Object> param, int pageNum, int pageSize);

    ResultDTO<Boolean> updateMemberPagesOnlineStatusByParam(int onlineStatus,int pageType,String shopId,String platformId);
    //以下改版：对用户模块编辑
    ResultDTO<MemberAdInfoBODTO> replaceMemberAdInfo(MemberAdInfoBODTO memberAdInfoBODTO);

    ResultDTO<Boolean> updateMemberAdInfo(MemberAdInfoBODTO memberAdInfoBODTO);

    ResultDTO<MemberAdInfoBODTO> getMemberAdInfoBOById(Long id);

    ResultDTO<Boolean> removeMemberAdInfoBOById(Long id);

    ResultDTO<MemberAdInfoBODTO> getMemberAdInfoBOByPageIdKeyName(Long pageId, String keyname);

    ResultDTO<List<MemberAdInfoBODTO>> getMemberAdInfoBOListByPageId(Long pageId);
}

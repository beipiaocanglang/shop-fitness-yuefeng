package com.bizcloud.memberdecoration.service;


import com.bizcloud.memberdecoration.modal.fitness.*;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface MemberTempModuleService {

    boolean deleteByPrimaryKey(Long id);

    boolean insertSelective(MemberPage record);

    MemberPage selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(MemberPage record);

    List<MemberPageVO> getMemberPageByParam(String shopId, String platformId);

    PageInfo<MemberPage> getMemberPageByTypeParam(Map<String, Object> param, int pageNum, int pageSize);

    //以下改版：对用户模块编辑
    boolean replaceMemberAdInfo(MemberAdInfoBO memberAdInfoBO);

    boolean updateMemberAdInfo(MemberAdInfoBO memberAdInfoBO);

    MemberAdInfoBO getMemberAdInfoBOById(Long id);

    boolean removeMemberAdInfoBOById(Long id);

    MemberAdInfoBO getMemberAdInfoBOByPageIdKeyName(Long pageId, String keyname);

    List<MemberAdInfoBO> getMemberAdInfoBOListByPageId(Long pageId);

    boolean updateMemberPagesOnlineStatusByParam(int onlineStatus,int pageType,String shopId,String platformId);
}

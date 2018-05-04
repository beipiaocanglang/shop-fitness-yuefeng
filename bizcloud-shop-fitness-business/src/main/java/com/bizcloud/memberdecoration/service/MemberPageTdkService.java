package com.bizcloud.memberdecoration.service;

import com.bizcloud.memberdecoration.modal.fitness.MemberPageTdk;

/**
 * Created by dev on 2017/7/10.
 */
public interface MemberPageTdkService {

    Boolean deleteByPrimaryKey(Long id);

    Boolean insertSelective(MemberPageTdk record);

    MemberPageTdk selectByPrimaryKey(Long id);

    Boolean updateByPrimaryKeySelective(MemberPageTdk record);

    MemberPageTdk selectByMemberPageId(Long memberPageId);
}

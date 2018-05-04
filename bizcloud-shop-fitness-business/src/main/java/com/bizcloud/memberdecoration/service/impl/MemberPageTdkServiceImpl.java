package com.bizcloud.memberdecoration.service.impl;

import com.bizcloud.memberdecoration.dao.memberpagetdk.MemberPageTdkMapper;
import com.bizcloud.memberdecoration.modal.fitness.MemberPageTdk;
import com.bizcloud.memberdecoration.service.MemberPageTdkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dev on 2017/7/10.
 */
@Service("MemberPageTdkService")
public class MemberPageTdkServiceImpl implements MemberPageTdkService {
    @Resource
    private MemberPageTdkMapper memberPageTdkMapper;

    @Override
    public Boolean deleteByPrimaryKey(Long id) {
        return memberPageTdkMapper.deleteByPrimaryKey(id)>=0;
    }

    @Override
    public Boolean insertSelective(MemberPageTdk record) {
        return memberPageTdkMapper.insertSelective(record)>0;
    }

    @Override
    public MemberPageTdk selectByMemberPageId(Long memberPageId) {
        return memberPageTdkMapper.selectByMemberPageId(memberPageId);
    }

    @Override
    public MemberPageTdk selectByPrimaryKey(Long id) {
        return memberPageTdkMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean updateByPrimaryKeySelective(MemberPageTdk record) {
        return memberPageTdkMapper.updateByPrimaryKeySelective(record)>0;
    }
}

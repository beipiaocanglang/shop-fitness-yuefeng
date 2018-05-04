package com.bizcloud.memberdecoration.service.impl;



import com.bizcloud.memberdecoration.dao.memberadinfo.MemberAdInfoReleaseMapper;
import com.bizcloud.memberdecoration.dao.memberpage.MemberPageMapper;
import com.bizcloud.memberdecoration.modal.fitness.MemberAdInfoBO;
import com.bizcloud.memberdecoration.modal.fitness.MemberPage;
import com.bizcloud.memberdecoration.modal.fitness.MemberPageVO;
import com.bizcloud.memberdecoration.service.MemberTempModuleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("MemberTempModuleService")
public class MemberTempModuleServiceImpl implements MemberTempModuleService {


    @Resource
    private MemberPageMapper memberPageMapper;

    @Resource
    private MemberAdInfoReleaseMapper memberAdInfoReleaseMapper;

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return memberPageMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean insertSelective(MemberPage record) {
        return memberPageMapper.insertSelective(record)>0;
    }



    @Override
    public MemberPage selectByPrimaryKey(Long id) {
        return memberPageMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(MemberPage record) {
        return memberPageMapper.updateByPrimaryKeySelective(record)>0;
    }

    @Override
    public PageInfo<MemberPage> getMemberPageByTypeParam(Map<String, Object> param, int pageNum, int pageSize) {

        Page<MemberPage> page = memberPageMapper.getMemberPageByTypeParam(param,new RowBounds(pageNum,pageSize));
        if (page != null) {
            return new PageInfo<>(page, page.getPages());
        }else {
            return new PageInfo<>();
        }

    }

    @Override
    public boolean updateMemberPagesOnlineStatusByParam(int onlineStatus, int pageType, String shopId, String platformId) {
        return memberPageMapper.updateMemberPagesOnlineStatusByParam(onlineStatus, pageType, shopId, platformId)>0;
    }

    @Override
    public List<MemberPageVO> getMemberPageByParam(String shopId, String platformId) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("shopId",shopId);
        param.put("platformId",platformId);

        return memberPageMapper.getMemberPageByParam(param);
    }

    //MemberAdInfoRelease
    @Override
    public boolean replaceMemberAdInfo(MemberAdInfoBO memberAdInfoBO) {
        return memberAdInfoReleaseMapper.insertSelective(memberAdInfoBO)>0;
    }

    @Override
    public boolean updateMemberAdInfo(MemberAdInfoBO memberAdInfoBO) {
        return memberAdInfoReleaseMapper.updateByPrimaryKeySelective(memberAdInfoBO)>=0;
    }

    @Override
    public List<MemberAdInfoBO> getMemberAdInfoBOListByPageId(Long pageId) {
        return memberAdInfoReleaseMapper.getMemberAdInfoBOListByPageId(pageId);
    }

    @Override
    public MemberAdInfoBO getMemberAdInfoBOByPageIdKeyName(Long pageId, String keyname) {
        return memberAdInfoReleaseMapper.getMemberAdInfoBOByPageIdKeyName(pageId, keyname);
    }

    @Override
    public MemberAdInfoBO getMemberAdInfoBOById(Long id) {
        return memberAdInfoReleaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean removeMemberAdInfoBOById(Long id) {
        return memberAdInfoReleaseMapper.deleteByPrimaryKey(id)>0;
    }
}

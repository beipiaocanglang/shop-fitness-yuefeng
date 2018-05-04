package com.bizcloud.memberdecoration.client;

import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.framework.base.ResultDTOBuilder;
import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageTdkDTO;
import com.bizcloud.memberdecoration.modal.fitness.MemberPageTdk;
import com.bizcloud.memberdecoration.service.MemberPageTdkService;
import com.bizcloud.memberdecoration.util.MemberPageTDKBeanConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dev on 2017/7/10.
 */
@Service("MemberPageTdkClient")
public class MemberPageTdkClientImpl implements MemberPageTdkClient {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Resource
    private MemberPageTdkService memberPageTdkService;

    @Override
    public ResultDTO<Boolean> deleteByPrimaryKey(Long id) {
        ResultDTO<Boolean> resultDTO;

        try {
            resultDTO = ResultDTOBuilder.success(memberPageTdkService.deleteByPrimaryKey(id));
        } catch (Exception e) {
            LOG.error("删除用户模版TDK信息异常.", e);
            resultDTO = ResultDTOBuilder.failure(e);
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<Boolean> insertSelective(MemberPageTdkDTO record) {
        ResultDTO<Boolean> resultDTO;
        MemberPageTdk memberPageTdk = MemberPageTDKBeanConverter.mptDTOtoMpt(record);

        try {
            resultDTO = ResultDTOBuilder.success(memberPageTdkService.insertSelective(memberPageTdk));
        } catch (Exception e) {
            LOG.error("插入用户模版TDK信息异常.", e);
            resultDTO = ResultDTOBuilder.failure(e);
        }

        return resultDTO;
    }
    @Override
    public ResultDTO<Boolean> updateByPrimaryKeySelective(MemberPageTdkDTO record) {
        ResultDTO<Boolean> resultDTO;
        MemberPageTdk memberPageTdk = MemberPageTDKBeanConverter.mptDTOtoMpt(record);
        try {
            resultDTO = ResultDTOBuilder.success(memberPageTdkService.updateByPrimaryKeySelective(memberPageTdk));
        } catch (Exception e) {
            LOG.error("更新用户模版TDK信息异常.", e);
            resultDTO = ResultDTOBuilder.failure(e);
        }
        return resultDTO;
    }
    @Override
    public ResultDTO<MemberPageTdkDTO> selectByPrimaryKey(Long id) {

        ResultDTO<MemberPageTdkDTO> resultDTO;

        try {
            MemberPageTdk memberPageTdk = memberPageTdkService.selectByPrimaryKey(id);
            MemberPageTdkDTO memberPageTdkDTO = MemberPageTDKBeanConverter.mpttoMptDTO(memberPageTdk);
            resultDTO = ResultDTOBuilder.success(memberPageTdkDTO);
        } catch (Exception e) {
            LOG.error("按ID查询用户模版TDK信息异常.", e);
            resultDTO = ResultDTOBuilder.failure(e);
        }


        return resultDTO;
    }



    @Override
    public ResultDTO<MemberPageTdkDTO> selectByMemberPageId(Long memberPageId) {


        ResultDTO<MemberPageTdkDTO> resultDTO;

        try {
            MemberPageTdk memberPageTdk = memberPageTdkService.selectByMemberPageId(memberPageId);
            MemberPageTdkDTO memberPageTdkDTO = MemberPageTDKBeanConverter.mpttoMptDTO(memberPageTdk);
            resultDTO = ResultDTOBuilder.success(memberPageTdkDTO);
        } catch (Exception e) {
            LOG.error("按用户模版ID查询用户模版TDK信息异常.", e);
            resultDTO = ResultDTOBuilder.failure(e);
        }


        return resultDTO;
    }
}

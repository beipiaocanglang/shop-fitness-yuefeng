package com.bizcloud.memberdecoration.client;

import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.framework.base.ResultDTOBuilder;
import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.dto.fitness.MemberAdInfoBODTO;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageDTO;
import com.bizcloud.memberdecoration.dto.fitness.MemberPageVODTO;
import com.bizcloud.memberdecoration.modal.fitness.MemberAdInfoBO;
import com.bizcloud.memberdecoration.modal.fitness.MemberPage;
import com.bizcloud.memberdecoration.modal.fitness.MemberPageVO;
import com.bizcloud.memberdecoration.service.MemberTempModuleService;
import com.bizcloud.memberdecoration.util.FitmentMMBeanConverter;
import com.bizcloud.memberdecoration.util.FitmentMPBeanConverter;
import com.bizcloud.memberdecoration.util.FitmentMPMBBeanConverter;
import com.bizcloud.memberdecoration.util.PageInfoUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("MemberTempModuleClient")
public class MemberTempModuleClientImpl implements MemberTempModuleClient {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Resource
    private MemberTempModuleService memberTempModuleService;

    @Override
    public ResultDTO<Boolean> deleteMemberPageByMemberPageId(Long id) {
        ResultDTO<Boolean> resultDTO;
        try {
            resultDTO = ResultDTOBuilder.success(memberTempModuleService.deleteByPrimaryKey(id));
        } catch (Exception e) {
            LOG.error("删除用户模版信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<MemberPageDTO> insertSelectiveMemberPage(MemberPageDTO mpdto) {
        ResultDTO<MemberPageDTO> resultDTO;
        try {
            MemberPage mp = FitmentMPBeanConverter.mpDTOtoMp(mpdto);
            if(memberTempModuleService.insertSelective(mp)){
                MemberPageDTO reMpdto = FitmentMPBeanConverter.mptompDTO(mp);
                resultDTO = ResultDTOBuilder.success(reMpdto);
            }else{
                resultDTO = ResultDTOBuilder.failure("700001", "插入数据异常");
            }

        } catch (Exception e) {
            LOG.error("新添用户模版信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<MemberPageDTO> selectMemberPageByMemberPageId(Long id) {
        ResultDTO<MemberPageDTO> resultDTO;
        try {

            MemberPage mp = memberTempModuleService.selectByPrimaryKey(id);
            if (mp != null) {
                MemberPageDTO mpdto = FitmentMPBeanConverter.mptompDTO(mp);
                resultDTO = ResultDTOBuilder.success(mpdto);
            } else {
                resultDTO = ResultDTOBuilder.success(null);
            }
        } catch (Exception e) {
            LOG.error("查询用户模版信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<Boolean> updateMemberPageByPrimaryKeySelective(MemberPageDTO mpdto) {
        ResultDTO<Boolean> resultDTO;
        try {
            MemberPage mp = FitmentMPBeanConverter.mpDTOtoMp(mpdto);
            resultDTO = ResultDTOBuilder.success(memberTempModuleService.updateByPrimaryKeySelective(mp));
        } catch (Exception e) {
            LOG.error("新添用户模版信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<List<MemberPageVODTO>> getMemberPageByParam(String shopId, String platformId) {
        ResultDTO<List<MemberPageVODTO>> resultDTO;
        try {
            List<MemberPageVO> list = memberTempModuleService.getMemberPageByParam(shopId, platformId);
            if (list != null && CollectionUtils.isNotEmpty(list)) {
                List<MemberPageVODTO> resultList = FitmentMPMBBeanConverter.mmlisttommDTOlist(list);
                resultDTO = ResultDTOBuilder.success(resultList);
            } else {
                resultDTO = ResultDTOBuilder.success(null);
            }
        } catch (Exception e) {
            LOG.error("查询用户模版信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<PageInfo<MemberPageDTO>> getMemberPageByTypeParam(Map<String, Object> param, int pageNum, int pageSize) {
        ResultDTO<PageInfo<MemberPageDTO>> resultDTO;
        try {
            PageInfo<MemberPage> pageMemberPage = memberTempModuleService.getMemberPageByTypeParam(param, pageNum, pageSize);
            if (pageMemberPage != null && CollectionUtils.isNotEmpty(pageMemberPage.getList())) {
                PageInfo<MemberPageDTO> pageMemberPageDTO = new PageInfo<>();
                List<MemberPageDTO> list = FitmentMPBeanConverter.mplisttompDTOlist(pageMemberPage.getList());
                PageInfoUtils.clonePageInfo(pageMemberPage, pageMemberPageDTO);
                pageMemberPageDTO.setList(list);
                resultDTO = ResultDTOBuilder.success(pageMemberPageDTO);
            } else {
                resultDTO = ResultDTOBuilder.success(null);
            }
        } catch (Exception e) {
            LOG.error("查询用户模版信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<MemberAdInfoBODTO> replaceMemberAdInfo(MemberAdInfoBODTO memberAdInfoBODTO) {
        ResultDTO<MemberAdInfoBODTO> resultDTO;

        try {
            MemberAdInfoBO mb = FitmentMMBeanConverter.mmDTOtoMm(memberAdInfoBODTO);
            if(memberTempModuleService.replaceMemberAdInfo(mb)){
                MemberAdInfoBODTO mbdto = FitmentMMBeanConverter.mmtommDTO(mb);
                resultDTO = ResultDTOBuilder.success(mbdto);
            }else{
                resultDTO = ResultDTOBuilder.failure("700001", "插入数据异常");
            }
        } catch (Exception e) {
            LOG.error("添加用户模块信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Boolean> updateMemberAdInfo(MemberAdInfoBODTO memberAdInfoBODTO) {
        ResultDTO<Boolean> resultDTO;

        try {
            MemberAdInfoBO mb = FitmentMMBeanConverter.mmDTOtoMm(memberAdInfoBODTO);
            resultDTO = ResultDTOBuilder.success(memberTempModuleService.updateMemberAdInfo(mb));
        } catch (Exception e) {
            LOG.error("修改用户模块信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<MemberAdInfoBODTO> getMemberAdInfoBOById(Long id) {
        ResultDTO<MemberAdInfoBODTO> resultDTO;

        try {
            MemberAdInfoBO mb = memberTempModuleService.getMemberAdInfoBOById(id);
            if (mb != null) {
                MemberAdInfoBODTO mbdto = FitmentMMBeanConverter.mmtommDTO(mb);
                resultDTO = ResultDTOBuilder.success(mbdto);
            } else {
                resultDTO = ResultDTOBuilder.success(null);
            }
        } catch (Exception e) {
            LOG.error("查询用户模块信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Boolean> removeMemberAdInfoBOById(Long id) {
        ResultDTO<Boolean> resultDTO;

        try {
            resultDTO = ResultDTOBuilder.success(memberTempModuleService.removeMemberAdInfoBOById(id));
        } catch (Exception e) {
            LOG.error("删除用户模块信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<MemberAdInfoBODTO> getMemberAdInfoBOByPageIdKeyName(Long pageId, String keyname) {
        ResultDTO<MemberAdInfoBODTO> resultDTO;

        try {
            MemberAdInfoBO mb = memberTempModuleService.getMemberAdInfoBOByPageIdKeyName(pageId,keyname);
            if (mb != null) {
                MemberAdInfoBODTO mbdto = FitmentMMBeanConverter.mmtommDTO(mb);
                resultDTO = ResultDTOBuilder.success(mbdto);
            } else {
                resultDTO = ResultDTOBuilder.success(null);
            }
        } catch (Exception e) {
            LOG.error("查询用户模块信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Boolean> updateMemberPagesOnlineStatusByParam(int onlineStatus, int pageType, String shopId, String platformId) {
        ResultDTO<Boolean> resultDTO;
        try {
            resultDTO = ResultDTOBuilder.success(memberTempModuleService.updateMemberPagesOnlineStatusByParam(onlineStatus, pageType, shopId, platformId));
        } catch (Exception e) {
            LOG.error("批量修改用户模版上线信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<List<MemberAdInfoBODTO>> getMemberAdInfoBOListByPageId(Long pageId) {
        ResultDTO<List<MemberAdInfoBODTO>> resultDTO;
        try {
            List<MemberAdInfoBO> list = memberTempModuleService.getMemberAdInfoBOListByPageId(pageId);
            if(list !=null && CollectionUtils.isNotEmpty(list)){
                List<MemberAdInfoBODTO> listdto = FitmentMMBeanConverter.mmlisttommDTOlist(list);
                resultDTO = ResultDTOBuilder.success(listdto);
            }else{
                resultDTO = ResultDTOBuilder.success(null);
            }
        } catch (Exception e) {
            LOG.error("查询用户模块信息异常.", e);
            resultDTO = ResultDTOBuilder.failure("700001", e);
        }


        return resultDTO;
    }
}

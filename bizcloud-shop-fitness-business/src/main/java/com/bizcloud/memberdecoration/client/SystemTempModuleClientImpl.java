package com.bizcloud.memberdecoration.client;

import javax.annotation.Resource;

import com.bizcloud.framework.base.ResultDTO;
import com.bizcloud.framework.base.ResultDTOBuilder;
import com.bizcloud.framework.exception.BizException;
import com.bizcloud.memberdecoration.dto.fitness.SystemModuleDTO;
import com.bizcloud.memberdecoration.dto.fitness.SystemTemplateDTO;
import com.bizcloud.memberdecoration.modal.fitness.SystemModule;
import com.bizcloud.memberdecoration.modal.fitness.SystemTemplate;
import com.bizcloud.memberdecoration.util.FitmentSMBeanConverter;
import com.bizcloud.memberdecoration.util.FitmentSTBeanConverter;
import com.bizcloud.memberdecoration.util.PageInfoUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.bizcloud.framework.logging.Logger;
import com.bizcloud.framework.logging.LoggerFactory;
import com.bizcloud.memberdecoration.service.SystemtTempModuleService;

import java.util.List;
import java.util.Map;

@Service("SystemTempModuleClient")
public class SystemTempModuleClientImpl implements SystemTempModuleClient {

	private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SystemtTempModuleService systemtTempModuleService;

	@Override
	public ResultDTO<PageInfo<SystemTemplateDTO>> getSystemTemplatePage(int pageNum, int pageSize, Map<String, Object> map) {
		ResultDTO<PageInfo<SystemTemplateDTO>> resultDTO ;

		try {
			PageInfo<SystemTemplate> list = systemtTempModuleService.getSystemTemplatePage(pageNum,pageSize,map);
			if(null != list && CollectionUtils.isNotEmpty(list.getList())){
                PageInfo<SystemTemplateDTO> page = new PageInfo<>();
                List<SystemTemplateDTO> dtolist= FitmentSTBeanConverter.stlisttoStDTOlist(list.getList());
                PageInfoUtils.clonePageInfo(list, page);//未对list做出替换
				page.setList(dtolist);
				resultDTO = ResultDTOBuilder.success(page);
            }else{
				if (LOG.isInfoEnabled()) {
					LOG.info("查询分页信息DAO层返回空");
				}
				resultDTO = ResultDTOBuilder.success(null);
			}
		} catch (Exception e) {
			LOG.error("分页查询信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}

		return resultDTO;
	}

	@Override
	public ResultDTO<PageInfo<SystemTemplateDTO>> getSystemTemplatePages(int pageNum, int pageSize) {
		ResultDTO<PageInfo<SystemTemplateDTO>> resultDTO ;

		try {
			PageInfo<SystemTemplate> list = systemtTempModuleService.getSystemTemplatePages(pageNum,pageSize);
			if(null != list && CollectionUtils.isNotEmpty(list.getList())){
				PageInfo<SystemTemplateDTO> page = new PageInfo<>();
				List<SystemTemplateDTO> dtolist= FitmentSTBeanConverter.stlisttoStDTOlist(list.getList());
				PageInfoUtils.clonePageInfo(list, page);//未对list做出替换
				page.setList(dtolist);
				resultDTO = ResultDTOBuilder.success(page);
			}else{
				if (LOG.isInfoEnabled()) {
					LOG.info("查询模版分页信息DAO层返回空");
				}
				resultDTO = ResultDTOBuilder.success(null);
			}
		} catch (Exception e) {
			LOG.error("分页查询信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}

		return resultDTO;
	}

	@Override
	public ResultDTO<List<SystemTemplateDTO>> getSystemTemplateList(int pageNum, int pageSize) {
		ResultDTO<List<SystemTemplateDTO>> resultDTO ;

		try {
			List<SystemTemplate> list = systemtTempModuleService.getSystemTemplateList(pageNum,pageSize);
			if(null != list && CollectionUtils.isNotEmpty(list)){

				List<SystemTemplateDTO> dtolist= FitmentSTBeanConverter.stlisttoStDTOlist(list);
				resultDTO = ResultDTOBuilder.success(dtolist);
			}else{
				if (LOG.isInfoEnabled()) {
					LOG.info("查询分页信息DAO层返回空");
				}
				resultDTO = ResultDTOBuilder.success(null);
			}
		} catch (Exception e) {
			LOG.error("分页查询信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}

		return resultDTO;
	}

	@Override
	public ResultDTO<List<SystemTemplateDTO>> getAllSystemTemplateList() {
		ResultDTO<List<SystemTemplateDTO>> resultDTO ;

		try {
			List<SystemTemplate> list = systemtTempModuleService.getAllSystemTemplateList();
			if(null != list && CollectionUtils.isNotEmpty(list)){
				List<SystemTemplateDTO> dtolist= FitmentSTBeanConverter.stlisttoStDTOlist(list);
				resultDTO = ResultDTOBuilder.success(dtolist);
			}else{
				if (LOG.isInfoEnabled()) {
					LOG.info("查询所有模版信息DAO层返回空");
				}
				resultDTO = ResultDTOBuilder.success(null);
			}
		} catch (Exception e) {
			LOG.error("查询所有模版信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}

		return resultDTO;
	}

	@Override
	public ResultDTO<Boolean> insertSystemTemplate(SystemTemplateDTO dto) {
		ResultDTO<Boolean> resultDTO ;
		try {
			SystemTemplate st = FitmentSTBeanConverter.stDTOtoSt(dto);
			resultDTO = ResultDTOBuilder.success(systemtTempModuleService.insertSystemTemplate(st));
		}catch (Exception e){
			LOG.error("插入模版信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700001", e);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO<Boolean> deleteSystemTemplate(long id) {
		ResultDTO<Boolean> resultDTO ;
		try {
			resultDTO = ResultDTOBuilder.success(systemtTempModuleService.deleteSystemTemplate(id));
		}catch (Exception e){
			LOG.error("删除模版信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700001", e);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO<Boolean> updateSystemTemplate(SystemTemplateDTO dto) {
		ResultDTO<Boolean> resultDTO ;
		try {
			SystemTemplate st = FitmentSTBeanConverter.stDTOtoSt(dto);
			resultDTO = ResultDTOBuilder.success(systemtTempModuleService.updateSystemTemplate(st));
		}catch (Exception e){
			LOG.error("修改模版信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700001", e);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO<SystemTemplateDTO> getSystemTemplateById(Long id) {
		ResultDTO<SystemTemplateDTO> resultDTO;

		try {
			SystemTemplate st = systemtTempModuleService.getSystemTemplateById(id);
			SystemTemplateDTO stdto=FitmentSTBeanConverter.sttoStDTO(st);
			resultDTO = ResultDTOBuilder.success(stdto);
		} catch (Exception e) {
			LOG.error("查询模版信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700001", e);
		}

		return resultDTO;
	}

	@Override
	public ResultDTO<PageInfo<SystemModuleDTO>> getSystemModulePage(int pageNum, int pageSize, Map<String, Object> map) {
		ResultDTO<PageInfo<SystemModuleDTO>> resultDTO ;

		try {
			PageInfo<SystemModule> list = systemtTempModuleService.getSystemModulePage(pageNum,pageSize,map);
			if(null != list && CollectionUtils.isNotEmpty(list.getList())){
				PageInfo<SystemModuleDTO> page = new PageInfo<>();
				List<SystemModuleDTO> dtolist= FitmentSMBeanConverter.smlisttoSmDTOlist(list.getList());
				PageInfoUtils.clonePageInfo(list, page);//未对list做出替换
				page.setList(dtolist);
				resultDTO = ResultDTOBuilder.success(page);
			}else{
				if (LOG.isInfoEnabled()) {
					LOG.info("查询模块列表信息DAO层返回空");
				}
				resultDTO = ResultDTOBuilder.success(null);
			}
		} catch (Exception e) {
			LOG.error("查询模块列表信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}

		return resultDTO;
	}

	@Override
	public ResultDTO<List<SystemModuleDTO>> getAllSystemModuleList() {
		ResultDTO<List<SystemModuleDTO>> resultDTO ;

		try {
			List<SystemModule> list = systemtTempModuleService.getAllSystemModuleList();
			if(null != list && CollectionUtils.isNotEmpty(list)){
				List<SystemModuleDTO> dtolist= FitmentSMBeanConverter.smlisttoSmDTOlist(list);
				resultDTO = ResultDTOBuilder.success(dtolist);
			}else{
				if (LOG.isInfoEnabled()) {
					LOG.info("查询所有模块信息DAO层返回空");
				}
				resultDTO = ResultDTOBuilder.success(null);
			}
		} catch (Exception e) {
			LOG.error("查询所有模块信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}

		return resultDTO;
	}

	@Override
	public ResultDTO<Boolean> insertSystemModule(SystemModuleDTO dto) {
		ResultDTO<Boolean> resultDTO;
		try {
			SystemModule sm = FitmentSMBeanConverter.smDTOtoSm(dto);
			resultDTO = ResultDTOBuilder.success(systemtTempModuleService.insertSystemModule(sm));
		} catch (Exception e) {
			LOG.error("新增模块信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO<Boolean> deleteSystemModule(long id) {
		ResultDTO<Boolean> resultDTO;
		try {
			resultDTO = ResultDTOBuilder.success(systemtTempModuleService.deleteSystemModule(id));
		} catch (Exception e) {
			LOG.error("删除模块信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO<Boolean> updateSystemModule(SystemModuleDTO dto) {
		ResultDTO<Boolean> resultDTO;
		try {
			SystemModule sm = FitmentSMBeanConverter.smDTOtoSm(dto);
			resultDTO = ResultDTOBuilder.success(systemtTempModuleService.updateSystemModule(sm));
		} catch (Exception e) {
			LOG.error("修改模块信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}
		return resultDTO;
	}

	@Override
	public ResultDTO<SystemModuleDTO> getSystemModule(Long id) {

		ResultDTO<SystemModuleDTO> resultDTO;
		try {
			SystemModuleDTO dto = FitmentSMBeanConverter.smtoSmDTO(systemtTempModuleService.getSystemModule(id));
			if(null != dto){
                resultDTO = ResultDTOBuilder.success(dto);
            }else{
                if (LOG.isInfoEnabled()) {
                    LOG.info("查询所有模块信息DAO层返回空");
                }
                resultDTO = ResultDTOBuilder.success(null);
            }
		} catch (Exception e) {
			LOG.error("查询模块信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}

		return resultDTO;
	}

	@Override
	public ResultDTO<SystemModuleDTO> selectBySignname(String signname) {
		ResultDTO<SystemModuleDTO> resultDTO;
		try {
			SystemModuleDTO dto = FitmentSMBeanConverter.smtoSmDTO(systemtTempModuleService.selectBySignname(signname));
			if(null != dto){
				resultDTO = ResultDTOBuilder.success(dto);
			}else{
				if (LOG.isInfoEnabled()) {
					LOG.info("查询模块信息DAO层返回空");
				}
				resultDTO = ResultDTOBuilder.success(null);
			}
		} catch (Exception e) {
			LOG.error("查询模块信息异常.", e);
			resultDTO = ResultDTOBuilder.failure("700002", e);
		}

		return resultDTO;
	}
}

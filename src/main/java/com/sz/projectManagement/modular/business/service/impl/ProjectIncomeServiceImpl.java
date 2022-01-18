package com.sz.projectManagement.modular.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.roses.kernel.rule.exception.base.ServiceException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sz.projectManagement.core.exception.BusinessException;
import com.sz.projectManagement.modular.business.entity.InvoiceRecords;
import com.sz.projectManagement.modular.business.entity.ProjectIncome;
import com.sz.projectManagement.modular.business.entity.ReturnRecord;
import com.sz.projectManagement.modular.business.enums.ProjectIncomeExceptionEnum;
import com.sz.projectManagement.modular.business.mapper.InvoiceRecordsMapper;
import com.sz.projectManagement.modular.business.mapper.ProjectIncomeMapper;
import com.sz.projectManagement.modular.business.mapper.ReturnRecordMapper;
import com.sz.projectManagement.modular.business.pojo.request.ProjectIncomeRequest;
import com.sz.projectManagement.modular.business.pojo.response.ProjectIncomeResponse;
import com.sz.projectManagement.modular.business.service.ProjectIncomeService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务实现层
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@Service
public class ProjectIncomeServiceImpl extends ServiceImpl<ProjectIncomeMapper, ProjectIncome> implements ProjectIncomeService {

    @Autowired
    private InvoiceRecordsMapper invoiceRecordsMapper;
    @Autowired
    private ReturnRecordMapper returnRecordMapper;

	@Override
    public void add(ProjectIncomeRequest projectIncomeRequest) {
        ProjectIncome projectIncome = new ProjectIncome();
        BeanUtil.copyProperties(projectIncomeRequest, projectIncome);
        this.save(projectIncome);
    }

    @Override
    public void del(ProjectIncomeRequest projectIncomeRequest) {
        QueryWrapper<InvoiceRecords> invoiceRecordsWrapper = new QueryWrapper<>();
        QueryWrapper<ReturnRecord> recordWrapper = new QueryWrapper<>();
        invoiceRecordsWrapper.eq("pid",projectIncomeRequest.getId());
        recordWrapper.eq("pid",projectIncomeRequest.getId());
        List<InvoiceRecords> invoiceRecords = invoiceRecordsMapper.selectList(invoiceRecordsWrapper);
        List<ReturnRecord> returnRecords = returnRecordMapper.selectList(recordWrapper);
        if (invoiceRecords.size()>0||returnRecords.size()>0){
            throw  new BusinessException(ProjectIncomeExceptionEnum.PROJECTINCOME_DEL_EXISTED);
        }else{
            ProjectIncome projectIncome = this.queryProjectIncome(projectIncomeRequest);
            this.removeById(projectIncome.getId());
        }

    }

    @Override
    public void edit(ProjectIncomeRequest projectIncomeRequest) {
        ProjectIncome projectIncome = this.queryProjectIncome(projectIncomeRequest);
        BeanUtil.copyProperties(projectIncomeRequest, projectIncome);
        this.updateById(projectIncome);
    }

    @Override
    public ProjectIncome detail(ProjectIncomeRequest projectIncomeRequest) {
        return this.queryProjectIncome(projectIncomeRequest);
    }

    @Override
    public PageResult<ProjectIncomeResponse> findPage(ProjectIncomeRequest projectIncomeRequest) {
        Page<ProjectIncomeResponse> sysRolePage = baseMapper.pages(PageFactory.defaultPage(), projectIncomeRequest);
        return PageResultFactory.createPageResult(sysRolePage);
    }

    @Override
    public List<ProjectIncome> findList(ProjectIncomeRequest projectIncomeRequest) {
        LambdaQueryWrapper<ProjectIncome> wrapper = this.createWrapper(projectIncomeRequest);
        return this.list(wrapper);
    }

    /**
     * 获取信息
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    private ProjectIncome queryProjectIncome(ProjectIncomeRequest projectIncomeRequest) {
        ProjectIncome projectIncome = this.getById(projectIncomeRequest.getId());
        if (ObjectUtil.isEmpty(projectIncome)) {
            throw new ServiceException(ProjectIncomeExceptionEnum.PROJECTINCOME_NOT_EXISTED);
        }
        return projectIncome;
    }

    /**
     * 创建查询wrapper
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    private LambdaQueryWrapper<ProjectIncome> createWrapper(ProjectIncomeRequest projectIncomeRequest) {
        LambdaQueryWrapper<ProjectIncome> queryWrapper = new LambdaQueryWrapper<>();

        Long id = projectIncomeRequest.getId();
        String contractNumber = projectIncomeRequest.getContractNumber();
        String contractName = projectIncomeRequest.getContractName();
        String contractType = projectIncomeRequest.getContractType();
        BigDecimal contractMoney = projectIncomeRequest.getContractMoney();

        Integer deleted = projectIncomeRequest.getDeleted();

        queryWrapper.eq(ObjectUtil.isNotNull(id), ProjectIncome::getId, id);
        queryWrapper.like(ObjectUtil.isNotEmpty(contractNumber), ProjectIncome::getContractNumber, contractNumber);
        queryWrapper.like(ObjectUtil.isNotEmpty(contractName), ProjectIncome::getContractName, contractName);
        queryWrapper.eq(ObjectUtil.isNotNull(contractType), ProjectIncome::getContractType, contractType);
        queryWrapper.eq(ObjectUtil.isNotNull(contractMoney), ProjectIncome::getContractMoney, contractMoney);

        queryWrapper.eq(ObjectUtil.isNotNull(deleted), ProjectIncome::getDeleted, deleted);

        return queryWrapper;
    }

}
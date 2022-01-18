package com.sz.projectManagement.modular.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.roses.kernel.rule.exception.base.ServiceException;
import com.sz.projectManagement.modular.business.entity.InvoiceRecords;
import com.sz.projectManagement.modular.business.enums.InvoiceRecordsExceptionEnum;
import com.sz.projectManagement.modular.business.mapper.InvoiceRecordsMapper;
import com.sz.projectManagement.modular.business.pojo.request.InvoiceRecordsRequest;
import com.sz.projectManagement.modular.business.pojo.response.InvoiceRecordsResponse;
import com.sz.projectManagement.modular.business.service.InvoiceRecordsService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 业务实现层
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@Service
public class InvoiceRecordsServiceImpl extends ServiceImpl<InvoiceRecordsMapper, InvoiceRecords> implements InvoiceRecordsService {

	@Override
    public void add(InvoiceRecordsRequest invoiceRecordsRequest) {
        InvoiceRecords invoiceRecords = new InvoiceRecords();
        BeanUtil.copyProperties(invoiceRecordsRequest, invoiceRecords);
        this.save(invoiceRecords);
    }

    @Override
    public void del(InvoiceRecordsRequest invoiceRecordsRequest) {
        InvoiceRecords invoiceRecords = this.queryInvoiceRecords(invoiceRecordsRequest);
        this.removeById(invoiceRecords.getId());
    }

    @Override
    public void edit(InvoiceRecordsRequest invoiceRecordsRequest) {
        InvoiceRecords invoiceRecords = this.queryInvoiceRecords(invoiceRecordsRequest);
        BeanUtil.copyProperties(invoiceRecordsRequest, invoiceRecords);
        this.updateById(invoiceRecords);
    }

    @Override
    public InvoiceRecords detail(InvoiceRecordsRequest invoiceRecordsRequest) {
        return this.queryInvoiceRecords(invoiceRecordsRequest);
    }

    @Override
    public PageResult<InvoiceRecordsResponse> findPage(InvoiceRecordsRequest invoiceRecordsRequest) {
        Page<InvoiceRecordsResponse> sysRolePage = baseMapper.pages(PageFactory.defaultPage(), invoiceRecordsRequest);
        return PageResultFactory.createPageResult(sysRolePage);
    }

    @Override
    public List<InvoiceRecords> findList(InvoiceRecordsRequest invoiceRecordsRequest) {
        LambdaQueryWrapper<InvoiceRecords> wrapper = this.createWrapper(invoiceRecordsRequest);
        return this.list(wrapper);
    }

    /**
     * 获取信息
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    private InvoiceRecords queryInvoiceRecords(InvoiceRecordsRequest invoiceRecordsRequest) {
        InvoiceRecords invoiceRecords = this.getById(invoiceRecordsRequest.getId());
        if (ObjectUtil.isEmpty(invoiceRecords)) {
            throw new ServiceException(InvoiceRecordsExceptionEnum.INVOICERECORDS_NOT_EXISTED);
        }
        return invoiceRecords;
    }

    /**
     * 创建查询wrapper
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    private LambdaQueryWrapper<InvoiceRecords> createWrapper(InvoiceRecordsRequest invoiceRecordsRequest) {
        LambdaQueryWrapper<InvoiceRecords> queryWrapper = new LambdaQueryWrapper<>();

        Long id = invoiceRecordsRequest.getId();
        String drawer = invoiceRecordsRequest.getDrawer();
        String invoiceNumber = invoiceRecordsRequest.getInvoiceNumber();
        BigDecimal invoiceAmount = invoiceRecordsRequest.getInvoiceAmount();
        String invoiceTime = invoiceRecordsRequest.getInvoiceTime();
        String remark = invoiceRecordsRequest.getRemark();

        queryWrapper.eq(ObjectUtil.isNotNull(id), InvoiceRecords::getId, id);
        queryWrapper.like(ObjectUtil.isNotEmpty(drawer), InvoiceRecords::getDrawer, drawer);
        queryWrapper.like(ObjectUtil.isNotEmpty(invoiceNumber), InvoiceRecords::getInvoiceNumber, invoiceNumber);
        queryWrapper.eq(ObjectUtil.isNotNull(invoiceAmount), InvoiceRecords::getInvoiceAmount, invoiceAmount);
        queryWrapper.eq(ObjectUtil.isNotNull(invoiceTime), InvoiceRecords::getInvoiceTime, invoiceTime);
        queryWrapper.like(ObjectUtil.isNotEmpty(remark), InvoiceRecords::getRemark, remark);

        return queryWrapper;
    }

}
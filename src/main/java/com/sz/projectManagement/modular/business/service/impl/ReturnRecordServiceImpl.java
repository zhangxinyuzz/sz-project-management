package com.sz.projectManagement.modular.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.roses.kernel.rule.exception.base.ServiceException;
import com.sz.projectManagement.modular.business.entity.ReturnRecord;
import com.sz.projectManagement.modular.business.enums.ReturnRecordExceptionEnum;
import com.sz.projectManagement.modular.business.mapper.ReturnRecordMapper;
import com.sz.projectManagement.modular.business.pojo.request.ReturnRecordRequest;
import com.sz.projectManagement.modular.business.pojo.response.ReturnRecordResponse;
import com.sz.projectManagement.modular.business.service.ReturnRecordService;
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
public class ReturnRecordServiceImpl extends ServiceImpl<ReturnRecordMapper, ReturnRecord> implements ReturnRecordService {

	@Override
    public void add(ReturnRecordRequest returnRecordRequest) {
        ReturnRecord returnRecord = new ReturnRecord();
        BeanUtil.copyProperties(returnRecordRequest, returnRecord);
        this.save(returnRecord);
    }

    @Override
    public void del(ReturnRecordRequest returnRecordRequest) {
        ReturnRecord returnRecord = this.queryReturnRecord(returnRecordRequest);
        this.removeById(returnRecord.getId());
    }

    @Override
    public void edit(ReturnRecordRequest returnRecordRequest) {
        ReturnRecord returnRecord = this.queryReturnRecord(returnRecordRequest);
        BeanUtil.copyProperties(returnRecordRequest, returnRecord);
        this.updateById(returnRecord);
    }

    @Override
    public ReturnRecord detail(ReturnRecordRequest returnRecordRequest) {
        return this.queryReturnRecord(returnRecordRequest);
    }

    @Override
    public PageResult<ReturnRecordResponse> findPage(ReturnRecordRequest returnRecordRequest) {
        Page<ReturnRecordResponse> sysRolePage = baseMapper.pages(PageFactory.defaultPage(), returnRecordRequest);
        return PageResultFactory.createPageResult(sysRolePage);
    }

    @Override
    public List<ReturnRecord> findList(ReturnRecordRequest returnRecordRequest) {
        LambdaQueryWrapper<ReturnRecord> wrapper = this.createWrapper(returnRecordRequest);
        return this.list(wrapper);
    }

    /**
     * 获取信息
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    private ReturnRecord queryReturnRecord(ReturnRecordRequest returnRecordRequest) {
        ReturnRecord returnRecord = this.getById(returnRecordRequest.getId());
        if (ObjectUtil.isEmpty(returnRecord)) {
            throw new ServiceException(ReturnRecordExceptionEnum.RETURNRECORD_NOT_EXISTED);
        }
        return returnRecord;
    }

    /**
     * 创建查询wrapper
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    private LambdaQueryWrapper<ReturnRecord> createWrapper(ReturnRecordRequest returnRecordRequest) {
        LambdaQueryWrapper<ReturnRecord> queryWrapper = new LambdaQueryWrapper<>();

        Long id = returnRecordRequest.getId();
        BigDecimal returnedMoney = returnRecordRequest.getReturnedMoney();
        String returnedTitle = returnRecordRequest.getReturnedTitle();
        String remark = returnRecordRequest.getRemark();
        String returnedTime = returnRecordRequest.getReturnedTime();

        queryWrapper.eq(ObjectUtil.isNotNull(id), ReturnRecord::getId, id);
        queryWrapper.eq(ObjectUtil.isNotNull(returnedMoney), ReturnRecord::getReturnedMoney, returnedMoney);
        queryWrapper.like(ObjectUtil.isNotEmpty(returnedTitle), ReturnRecord::getReturnedTitle, returnedTitle);
        queryWrapper.like(ObjectUtil.isNotEmpty(remark), ReturnRecord::getRemark, remark);
        queryWrapper.eq(ObjectUtil.isNotNull(returnedTime), ReturnRecord::getReturnedTime, returnedTime);

        return queryWrapper;
    }

}
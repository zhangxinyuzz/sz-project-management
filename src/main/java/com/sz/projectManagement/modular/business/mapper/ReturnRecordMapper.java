package com.sz.projectManagement.modular.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.projectManagement.modular.business.entity.ReturnRecord;
import com.sz.projectManagement.modular.business.pojo.request.ReturnRecordRequest;
import com.sz.projectManagement.modular.business.pojo.response.ReturnRecordResponse;
import org.apache.ibatis.annotations.Param;

/**
 *  Mapper 接口
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
public interface ReturnRecordMapper extends BaseMapper<ReturnRecord> {
    Page<ReturnRecordResponse> pages(Page<ReturnRecordResponse> page, @Param("paramCondition") ReturnRecordRequest request);

}
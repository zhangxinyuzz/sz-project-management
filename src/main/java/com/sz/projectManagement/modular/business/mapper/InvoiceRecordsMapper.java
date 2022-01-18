package com.sz.projectManagement.modular.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.projectManagement.modular.business.entity.InvoiceRecords;
import com.sz.projectManagement.modular.business.pojo.request.InvoiceRecordsRequest;
import com.sz.projectManagement.modular.business.pojo.response.InvoiceRecordsResponse;
import org.apache.ibatis.annotations.Param;

/**
 *  Mapper 接口
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
public interface InvoiceRecordsMapper extends BaseMapper<InvoiceRecords> {
    Page<InvoiceRecordsResponse> pages(Page<InvoiceRecordsResponse> page, @Param("paramCondition") InvoiceRecordsRequest request);

}
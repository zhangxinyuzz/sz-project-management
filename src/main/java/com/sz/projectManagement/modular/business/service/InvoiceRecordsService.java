package com.sz.projectManagement.modular.business.service;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.projectManagement.modular.business.entity.InvoiceRecords;
import com.sz.projectManagement.modular.business.pojo.request.InvoiceRecordsRequest;
import com.sz.projectManagement.modular.business.pojo.response.InvoiceRecordsResponse;

import java.util.List;

/**
 *  服务类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
public interface InvoiceRecordsService extends IService<InvoiceRecords> {

	/**
     * 新增
     *
     * @param invoiceRecordsRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void add(InvoiceRecordsRequest invoiceRecordsRequest);

	/**
     * 删除
     *
     * @param invoiceRecordsRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void del(InvoiceRecordsRequest invoiceRecordsRequest);

	/**
     * 编辑
     *
     * @param invoiceRecordsRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void edit(InvoiceRecordsRequest invoiceRecordsRequest);

	/**
     * 查询详情
     *
     * @param invoiceRecordsRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    InvoiceRecords detail(InvoiceRecordsRequest invoiceRecordsRequest);

	/**
     * 获取列表
     *
     * @param invoiceRecordsRequest        请求参数
     * @return List<InvoiceRecords>   返回结果
     * @author lipan
     * @date 2022/01/11 15:17
     */
    List<InvoiceRecords> findList(InvoiceRecordsRequest invoiceRecordsRequest);

	/**
     * 获取列表（带分页）
     *
     * @param invoiceRecordsRequest              请求参数
     * @return PageResult<InvoiceRecords>   返回结果
     * @author lipan
     * @date 2022/01/11 15:17
     */
    PageResult<InvoiceRecordsResponse> findPage(InvoiceRecordsRequest invoiceRecordsRequest);

}
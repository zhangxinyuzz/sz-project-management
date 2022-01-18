package com.sz.projectManagement.modular.business.controller;

import com.sz.projectManagement.modular.business.pojo.request.InvoiceRecordsRequest;
import com.sz.projectManagement.modular.business.service.InvoiceRecordsService;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 控制器
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@RestController
@ApiResource(name = "")
public class InvoiceRecordsController {

    @Resource
    private InvoiceRecordsService invoiceRecordsService;

    /**
     * 添加
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "添加", path = "/invoiceRecords/add")
    public ResponseData add(@RequestBody @Validated(InvoiceRecordsRequest.add.class) InvoiceRecordsRequest invoiceRecordsRequest) {
        invoiceRecordsService.add(invoiceRecordsRequest);
        return new SuccessResponseData();
    }

    /**
     * 删除
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "删除", path = "/invoiceRecords/delete")
    public ResponseData delete(@RequestBody @Validated(InvoiceRecordsRequest.delete.class) InvoiceRecordsRequest invoiceRecordsRequest) {
        invoiceRecordsService.del(invoiceRecordsRequest);
        return new SuccessResponseData();
    }

    /**
     * 编辑
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "编辑", path = "/invoiceRecords/edit")
    public ResponseData edit(@RequestBody @Validated(InvoiceRecordsRequest.edit.class) InvoiceRecordsRequest invoiceRecordsRequest) {
        invoiceRecordsService.edit(invoiceRecordsRequest);
        return new SuccessResponseData();
    }

    /**
     * 查看详情
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "查看详情", path = "/invoiceRecords/detail")
    public ResponseData detail(@Validated(InvoiceRecordsRequest.detail.class) InvoiceRecordsRequest invoiceRecordsRequest) {
        return new SuccessResponseData(invoiceRecordsService.detail(invoiceRecordsRequest));
    }

    /**
     * 获取列表
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "获取列表", path = "/invoiceRecords/list")
    public ResponseData list(InvoiceRecordsRequest invoiceRecordsRequest) {
        return new SuccessResponseData(invoiceRecordsService.findList(invoiceRecordsRequest));
    }

    /**
     * 获取列表（带分页）
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "分页查询", path = "/invoiceRecords/page")
    public ResponseData page(InvoiceRecordsRequest invoiceRecordsRequest) {
        return new SuccessResponseData(invoiceRecordsService.findPage(invoiceRecordsRequest));
    }

}
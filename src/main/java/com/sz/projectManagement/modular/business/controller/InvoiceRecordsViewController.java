package com.sz.projectManagement.modular.business.controller;

import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import org.springframework.stereotype.Controller;

/**
 * 界面
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@Controller
@ApiResource(name = "界面")
public class InvoiceRecordsViewController {

    /**
     * 首页
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "首页", path = "/view/invoiceRecords")
    public String invoiceRecordsIndex() {
        return "/modular/business/invoiceRecords.html";
    }

    /**
     * -新增
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "-新增", path = "/view/invoiceRecords/add")
    public String invoiceRecordsAdd() {
        return "/modular/business/invoice_records_add.html";
    }

    /**
     * -编辑
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "-编辑", path = "/view/invoiceRecords/edit")
    public String invoiceRecordsEdit() {
        return "/modular/business/invoice_records_edit.html";
    }

}
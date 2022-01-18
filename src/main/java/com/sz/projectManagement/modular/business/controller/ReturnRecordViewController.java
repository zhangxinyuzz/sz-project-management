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
public class ReturnRecordViewController {

    /**
     * 首页
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "首页", path = "/view/returnRecord")
    public String returnRecordIndex() {
        return "/modular/business/returnRecord.html";
    }

    /**
     * -新增
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "-新增", path = "/view/returnRecord/add")
    public String returnRecordAdd() {
        return "/modular/business/return_record_add.html";
    }

    /**
     * -编辑
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "-编辑", path = "/view/returnRecord/edit")
    public String returnRecordEdit() {
        return "/modular/business/return_record_edit.html";
    }

}
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
public class ProjectIncomeViewController {

    /**
     * 首页
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "首页", path = "/view/projectIncome")
    public String projectIncomeIndex() {
        return "/modular/business/projectIncome.html";
    }

    /**
     * -新增
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "-新增", path = "/view/projectIncome/add")
    public String projectIncomeAdd() {
        return "/modular/business/project_income_add.html";
    }

    /**
     * -编辑
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "-编辑", path = "/view/projectIncome/edit")
    public String projectIncomeEdit() {
        return "/modular/business/project_income_edit.html";
    }

}
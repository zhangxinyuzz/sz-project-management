package com.sz.projectManagement.modular.business.controller;

import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import org.springframework.stereotype.Controller;

/**
 * 所有项目界面
 *
 * @author lipan
 * @date 2022/01/12 09:57
 */
@Controller
@ApiResource(name = "所有项目界面")
public class ProjectViewController {

    /**
     * 所有项目首页
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @GetResource(name = "所有项目首页", path = "/view/project")
    public String projectIndex() {
        return "/modular/business/project.html";
    }

    /**
     * 所有项目-新增
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @GetResource(name = "所有项目-新增", path = "/view/project/add")
    public String projectAdd() {
        return "/modular/business/project_add.html";
    }

    /**
     * 所有项目-编辑
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @GetResource(name = "所有项目-编辑", path = "/view/project/edit")
    public String projectEdit() {
        return "/modular/business/project_edit.html";
    }

    /**
     * todo
     * @author: lipan
     * @date: 2022/1/12 11:38
     * @return java.lang.String
     **/
    @GetResource(name = "所有项目-详情", path = "/view/project/detail")
    public String projectDetail() {
        return "/modular/business/project_detail.html";
    }


}
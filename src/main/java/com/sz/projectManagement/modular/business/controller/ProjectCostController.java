package com.sz.projectManagement.modular.business.controller;

import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import com.alibaba.excel.EasyExcel;
import com.sz.projectManagement.modular.business.entity.User;
import com.sz.projectManagement.modular.business.pojo.request.ProjectCostRequest;
import com.sz.projectManagement.modular.business.service.ProjectCostService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 控制器
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@RestController
@ApiResource(name = "")
public class ProjectCostController {

    @Resource
    private ProjectCostService projectCostService;

    /**
     * 添加
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "添加", path = "/projectCost/add")
    public ResponseData add(@RequestBody @Validated(ProjectCostRequest.add.class) ProjectCostRequest projectCostRequest) {
        projectCostService.add(projectCostRequest);
        return new SuccessResponseData();
    }

    /**
     * 添加
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "添加", path = "/projectCost/addrengong")
    public ResponseData addrengong(@RequestBody @Validated(ProjectCostRequest.add.class) ProjectCostRequest projectCostRequest) {
        projectCostService.add(projectCostRequest);
        return new SuccessResponseData();
    }

    /**
     * 删除
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "删除", path = "/projectCost/delete")
    public ResponseData delete(@RequestBody @Validated(ProjectCostRequest.delete.class) ProjectCostRequest projectCostRequest) {
        projectCostService.del(projectCostRequest);
        return new SuccessResponseData();
    }

    /**
     * 编辑
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "编辑", path = "/projectCost/edit")
    public ResponseData edit(@RequestBody @Validated(ProjectCostRequest.edit.class) ProjectCostRequest projectCostRequest) {
        projectCostService.edit(projectCostRequest);
        return new SuccessResponseData();
    }

    /**
     * 查看详情
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "查看详情", path = "/projectCost/detail")
    public ResponseData detail(@Validated(ProjectCostRequest.detail.class) ProjectCostRequest projectCostRequest) {
        return new SuccessResponseData(projectCostService.detail(projectCostRequest));
    }

    /**
     * 获取列表
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "获取列表", path = "/projectCost/list")
    public ResponseData list(ProjectCostRequest projectCostRequest) {
        return new SuccessResponseData(projectCostService.findList(projectCostRequest));
    }

    /**
     * 获取列表（带分页）
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "分页查询", path = "/projectCost/page")
    public ResponseData page(ProjectCostRequest projectCostRequest) {
        return new SuccessResponseData(projectCostService.findPage(projectCostRequest));
    }

    /**
     * 导出Excel
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "导出Excel", path = "/projectCost/down")
    public void testRespExcel(HttpServletResponse response) throws IOException {
        projectCostService.downLoadExcel(response);
    }

}
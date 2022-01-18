package com.sz.projectManagement.modular.business.controller;

import com.sz.projectManagement.modular.business.pojo.request.ProjectIncomeRequest;
import com.sz.projectManagement.modular.business.service.ProjectIncomeService;
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
public class ProjectIncomeController {

    @Resource
    private ProjectIncomeService projectIncomeService;

    /**
     * 添加
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "添加", path = "/projectIncome/add")
    public ResponseData add(@RequestBody @Validated(ProjectIncomeRequest.add.class) ProjectIncomeRequest projectIncomeRequest) {
        projectIncomeService.add(projectIncomeRequest);
        return new SuccessResponseData();
    }

    /**
     * 删除
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "删除", path = "/projectIncome/delete")
    public ResponseData delete(@RequestBody @Validated(ProjectIncomeRequest.delete.class) ProjectIncomeRequest projectIncomeRequest) {
        projectIncomeService.del(projectIncomeRequest);
        return new SuccessResponseData();
    }

    /**
     * 编辑
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "编辑", path = "/projectIncome/edit")
    public ResponseData edit(@RequestBody @Validated(ProjectIncomeRequest.edit.class) ProjectIncomeRequest projectIncomeRequest) {
        projectIncomeService.edit(projectIncomeRequest);
        return new SuccessResponseData();
    }

    /**
     * 查看详情
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "查看详情", path = "/projectIncome/detail")
    public ResponseData detail(@Validated(ProjectIncomeRequest.detail.class) ProjectIncomeRequest projectIncomeRequest) {
        return new SuccessResponseData(projectIncomeService.detail(projectIncomeRequest));
    }

    /**
     * 获取列表
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "获取列表", path = "/projectIncome/list")
    public ResponseData list(ProjectIncomeRequest projectIncomeRequest) {
        return new SuccessResponseData(projectIncomeService.findList(projectIncomeRequest));
    }

    /**
     * 获取列表（带分页）
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "分页查询", path = "/projectIncome/page")
    public ResponseData page(ProjectIncomeRequest projectIncomeRequest) {
        return new SuccessResponseData(projectIncomeService.findPage(projectIncomeRequest));
    }

}
package com.sz.projectManagement.modular.business.controller;

import com.sz.projectManagement.modular.business.pojo.request.ProjectRequest;
import com.sz.projectManagement.modular.business.service.ProjectService;
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
 * 所有项目控制器
 *
 * @author lipan
 * @date 2022/01/12 09:57
 */
@RestController
@ApiResource(name = "所有项目")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    /**
     * 添加
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @PostResource(name = "添加", path = "/project/add")
    public ResponseData add(@RequestBody @Validated(ProjectRequest.add.class) ProjectRequest projectRequest) {
        projectService.add(projectRequest);
        return new SuccessResponseData();
    }

    /**
     * 删除
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @PostResource(name = "删除", path = "/project/delete")
    public ResponseData delete(@RequestBody @Validated(ProjectRequest.delete.class) ProjectRequest projectRequest) {
        projectService.del(projectRequest);
        return new SuccessResponseData();
    }

    /**
     * 编辑
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @PostResource(name = "编辑", path = "/project/edit")
    public ResponseData edit(@RequestBody @Validated(ProjectRequest.edit.class) ProjectRequest projectRequest) {
        projectService.edit(projectRequest);
        return new SuccessResponseData();
    }

    /**
     * 查看详情
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @GetResource(name = "查看详情", path = "/project/detail")
    public ResponseData detail(@Validated(ProjectRequest.detail.class) ProjectRequest projectRequest) {
        return new SuccessResponseData(projectService.detail(projectRequest));
    }

    /**
     * 获取列表
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @GetResource(name = "获取列表", path = "/project/list")
    public ResponseData list(ProjectRequest projectRequest) {
        return new SuccessResponseData(projectService.findList(projectRequest));
    }

    /**
     * 获取列表（带分页）
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    @GetResource(name = "分页查询", path = "/project/page")
    public ResponseData page(ProjectRequest projectRequest) {
        return new SuccessResponseData(projectService.findPage(projectRequest));
    }

}
package com.sz.projectManagement.modular.business.service;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;

import com.sz.projectManagement.modular.business.entity.Project;
import com.sz.projectManagement.modular.business.pojo.request.ProjectRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.projectManagement.modular.business.pojo.response.ProjectResponse;

import java.util.List;

/**
 * 所有项目 服务类
 *
 * @author lipan
 * @date 2022/01/12 09:57
 */
public interface ProjectService extends IService<Project> {

	/**
     * 新增
     *
     * @param projectRequest 请求参数
     * @author lipan
     * @date 2022/01/12 09:57
     */
    void add(ProjectRequest projectRequest);

	/**
     * 删除
     *
     * @param projectRequest 请求参数
     * @author lipan
     * @date 2022/01/12 09:57
     */
    void del(ProjectRequest projectRequest);

	/**
     * 编辑
     *
     * @param projectRequest 请求参数
     * @author lipan
     * @date 2022/01/12 09:57
     */
    void edit(ProjectRequest projectRequest);

	/**
     * 查询详情
     *
     * @param projectRequest 请求参数
     * @author lipan
     * @date 2022/01/12 09:57
     */
    Project detail(ProjectRequest projectRequest);

	/**
     * 获取列表
     *
     * @param projectRequest        请求参数
     * @return List<Project>   返回结果
     * @author lipan
     * @date 2022/01/12 09:57
     */
    List<Project> findList(ProjectRequest projectRequest);

	/**
     * 获取列表（带分页）
     *
     * @param projectRequest              请求参数
     * @return PageResult<Project>   返回结果
     * @author lipan
     * @date 2022/01/12 09:57
     */
    PageResult<ProjectResponse> findPage(ProjectRequest projectRequest);

}
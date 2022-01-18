package com.sz.projectManagement.modular.business.service;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.sz.projectManagement.modular.business.entity.ProjectIncome;
import com.sz.projectManagement.modular.business.pojo.request.ProjectIncomeRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.projectManagement.modular.business.pojo.response.ProjectIncomeResponse;

import java.util.List;

/**
 *  服务类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
public interface ProjectIncomeService extends IService<ProjectIncome> {

	/**
     * 新增
     *
     * @param projectIncomeRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void add(ProjectIncomeRequest projectIncomeRequest);

	/**
     * 删除
     *
     * @param projectIncomeRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void del(ProjectIncomeRequest projectIncomeRequest);

	/**
     * 编辑
     *
     * @param projectIncomeRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void edit(ProjectIncomeRequest projectIncomeRequest);

	/**
     * 查询详情
     *
     * @param projectIncomeRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    ProjectIncome detail(ProjectIncomeRequest projectIncomeRequest);

	/**
     * 获取列表
     *
     * @param projectIncomeRequest        请求参数
     * @return List<ProjectIncome>   返回结果
     * @author lipan
     * @date 2022/01/11 15:17
     */
    List<ProjectIncome> findList(ProjectIncomeRequest projectIncomeRequest);

	/**
     * 获取列表（带分页）
     *
     * @param projectIncomeRequest              请求参数
     * @return PageResult<ProjectIncome>   返回结果
     * @author lipan
     * @date 2022/01/11 15:17
     */
    PageResult<ProjectIncomeResponse> findPage(ProjectIncomeRequest projectIncomeRequest);

}
package com.sz.projectManagement.modular.business.service;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.sz.projectManagement.modular.business.entity.ProjectCost;
import com.sz.projectManagement.modular.business.pojo.request.ProjectCostRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.projectManagement.modular.business.pojo.response.ProjectCostResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *  服务类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
public interface ProjectCostService extends IService<ProjectCost> {

	/**
     * 新增
     *
     * @param projectCostRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void add(ProjectCostRequest projectCostRequest);

	/**
     * 删除
     *
     * @param projectCostRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void del(ProjectCostRequest projectCostRequest);

	/**
     * 编辑
     *
     * @param projectCostRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void edit(ProjectCostRequest projectCostRequest);

	/**
     * 查询详情
     *
     * @param projectCostRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    ProjectCost detail(ProjectCostRequest projectCostRequest);

	/**
     * 获取列表
     *
     * @param projectCostRequest        请求参数
     * @return List<ProjectCost>   返回结果
     * @author lipan
     * @date 2022/01/11 15:17
     */
    List<ProjectCost> findList(ProjectCostRequest projectCostRequest);

	/**
     * 获取列表（带分页）
     *
     * @param projectCostRequest              请求参数
     * @return PageResult<ProjectCost>   返回结果
     * @author lipan
     * @date 2022/01/11 15:17
     */
    PageResult<ProjectCostResponse> findPage(ProjectCostRequest projectCostRequest);
    /**
     * todo 导出excel
     * @author: 李攀
     * @date: 2022/1/17 11:37
     * @param response
     * @return void
     **/
    void downLoadExcel(HttpServletResponse response) throws IOException;

}
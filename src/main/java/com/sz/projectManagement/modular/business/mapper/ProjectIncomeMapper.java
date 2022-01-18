package com.sz.projectManagement.modular.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.projectManagement.modular.business.entity.ProjectIncome;
import com.sz.projectManagement.modular.business.pojo.request.ProjectCostRequest;
import com.sz.projectManagement.modular.business.pojo.request.ProjectIncomeRequest;
import com.sz.projectManagement.modular.business.pojo.response.ProjectIncomeResponse;
import org.apache.ibatis.annotations.Param;

/**
 *  Mapper 接口
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
public interface ProjectIncomeMapper extends BaseMapper<ProjectIncome> {
    Page<ProjectIncomeResponse> pages(Page<ProjectIncomeResponse> page, @Param("paramCondition") ProjectIncomeRequest request);

}
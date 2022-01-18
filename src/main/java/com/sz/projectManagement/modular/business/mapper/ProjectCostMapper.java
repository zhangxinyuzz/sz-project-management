package com.sz.projectManagement.modular.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.projectManagement.modular.business.entity.ProjectCost;
import com.sz.projectManagement.modular.business.pojo.request.ProjectCostRequest;
import com.sz.projectManagement.modular.business.pojo.response.ProjectCostResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper 接口
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
public interface ProjectCostMapper extends BaseMapper<ProjectCost> {

    Page<ProjectCostResponse> pages(Page<ProjectCostResponse> page, @Param("paramCondition") ProjectCostRequest request);

    List<ProjectCostResponse> list(@Param("paramCondition") ProjectCostRequest request);

}
package com.sz.projectManagement.modular.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sz.projectManagement.modular.business.entity.Project;
import com.sz.projectManagement.modular.business.pojo.request.ProjectRequest;
import com.sz.projectManagement.modular.business.pojo.response.ProjectResponse;
import org.apache.ibatis.annotations.Param;

/**
 * 所有项目 Mapper 接口
 *
 * @author lipan
 * @date 2022/01/12 09:57
 */
public interface ProjectMapper extends BaseMapper<Project> {
    Page<ProjectResponse> pages(Page<ProjectResponse> page, @Param("paramCondition") ProjectRequest request);

}
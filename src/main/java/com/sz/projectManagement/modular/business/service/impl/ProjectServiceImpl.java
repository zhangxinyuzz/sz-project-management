package com.sz.projectManagement.modular.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.rule.exception.base.ServiceException;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.projectManagement.core.exception.BusinessException;
import com.sz.projectManagement.modular.business.entity.Project;
import com.sz.projectManagement.modular.business.entity.ProjectCost;
import com.sz.projectManagement.modular.business.entity.ProjectIncome;
import com.sz.projectManagement.modular.business.enums.ProjectExceptionEnum;
import com.sz.projectManagement.modular.business.mapper.ProjectCostMapper;
import com.sz.projectManagement.modular.business.mapper.ProjectIncomeMapper;
import com.sz.projectManagement.modular.business.mapper.ProjectMapper;
import com.sz.projectManagement.modular.business.pojo.request.ProjectRequest;
import com.sz.projectManagement.modular.business.pojo.response.ProjectResponse;
import com.sz.projectManagement.modular.business.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 所有项目业务实现层
 *
 * @author lipan
 * @date 2022/01/12 09:57
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Autowired
    private ProjectIncomeMapper projectIncomeMapper;

    @Autowired
    private ProjectCostMapper projectCostMapper;

	@Override
    public void add(ProjectRequest projectRequest) {
        Project project = new Project();
        BeanUtil.copyProperties(projectRequest, project);
        this.save(project);
    }

    @Override
    public void del(ProjectRequest projectRequest) {
        QueryWrapper<ProjectIncome> incomeWrapper = new QueryWrapper<>();
        QueryWrapper<ProjectCost> costWrapper = new QueryWrapper<>();
        incomeWrapper.eq("pid",projectRequest.getId());
        costWrapper.eq("pid",projectRequest.getId());
        List<ProjectIncome> projectIncomes = projectIncomeMapper.selectList(incomeWrapper);
        List<ProjectCost> projectCosts = projectCostMapper.selectList(costWrapper);
        if (projectIncomes.size()>0||projectCosts.size()>0) {
            throw new BusinessException(ProjectExceptionEnum.PROJECT_DEL_EXISTED);
        }else {
            Project project = this.queryProject(projectRequest);
            this.removeById(project.getId());
        }
    }

    @Override
    public void edit(ProjectRequest projectRequest) {
        Project project = this.queryProject(projectRequest);
        BeanUtil.copyProperties(projectRequest, project);
        this.updateById(project);
    }

    @Override
    public Project detail(ProjectRequest projectRequest) {
        return this.queryProject(projectRequest);
    }

    @Override
    public PageResult<ProjectResponse> findPage(ProjectRequest projectRequest) {
        Page<ProjectResponse> sysRolePage = baseMapper.pages(PageFactory.defaultPage(), projectRequest);
        return PageResultFactory.createPageResult(sysRolePage);
    }

    @Override
    public List<Project> findList(ProjectRequest projectRequest) {
        LambdaQueryWrapper<Project> wrapper = this.createWrapper(projectRequest);
        return this.list(wrapper);
    }

    /**
     * 获取信息
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    private Project queryProject(ProjectRequest projectRequest) {
        Project project = this.getById(projectRequest.getId());
        if (ObjectUtil.isEmpty(project)) {
            throw new ServiceException(ProjectExceptionEnum.PROJECT_NOT_EXISTED);
        }
        return project;
    }

    /**
     * 创建查询wrapper
     *
     * @author lipan
     * @date 2022/01/12 09:57
     */
    private LambdaQueryWrapper<Project> createWrapper(ProjectRequest projectRequest) {
        LambdaQueryWrapper<Project> queryWrapper = new LambdaQueryWrapper<>();

        Long id = projectRequest.getId();
        String customerName = projectRequest.getCustomerName();
        String name = projectRequest.getName();
        String type = projectRequest.getType();
        String manager = projectRequest.getManager();
        String clientManager = projectRequest.getClientManager();
        String clientManagerPhone = projectRequest.getClientManagerPhone();
        String projectContact = projectRequest.getProjectContact();
        String projectContactPhone = projectRequest.getProjectContactPhone();
        String projectLocation = projectRequest.getProjectLocation();
        String projectDescription = projectRequest.getProjectDescription();
        String remark = projectRequest.getRemark();
        String startTime = projectRequest.getStartTime();
        String endTime = projectRequest.getEndTime();
        Integer state = projectRequest.getState();
        Boolean deleted = projectRequest.getDeleted();

        queryWrapper.eq(ObjectUtil.isNotNull(id), Project::getId, id);
        queryWrapper.like(ObjectUtil.isNotEmpty(customerName), Project::getCustomerName, customerName);
        queryWrapper.like(ObjectUtil.isNotEmpty(name), Project::getName, name);
        queryWrapper.like(ObjectUtil.isNotEmpty(type), Project::getType, type);
        queryWrapper.like(ObjectUtil.isNotEmpty(manager), Project::getManager, manager);
        queryWrapper.like(ObjectUtil.isNotEmpty(clientManager), Project::getClientManager, clientManager);
        queryWrapper.like(ObjectUtil.isNotEmpty(clientManagerPhone), Project::getClientManagerPhone, clientManagerPhone);
        queryWrapper.like(ObjectUtil.isNotEmpty(projectContact), Project::getProjectContact, projectContact);
        queryWrapper.like(ObjectUtil.isNotEmpty(projectContactPhone), Project::getProjectContactPhone, projectContactPhone);
        queryWrapper.like(ObjectUtil.isNotEmpty(projectLocation), Project::getProjectLocation, projectLocation);
        queryWrapper.like(ObjectUtil.isNotEmpty(projectDescription), Project::getProjectDescription, projectDescription);
        queryWrapper.like(ObjectUtil.isNotEmpty(remark), Project::getRemark, remark);
        queryWrapper.eq(ObjectUtil.isNotNull(startTime), Project::getStartTime, startTime);
        queryWrapper.eq(ObjectUtil.isNotNull(endTime), Project::getEndTime, endTime);
        queryWrapper.eq(ObjectUtil.isNotNull(state), Project::getState, state);
        queryWrapper.eq(ObjectUtil.isNotNull(deleted), Project::getDeleted, deleted);

        return queryWrapper;
    }

}
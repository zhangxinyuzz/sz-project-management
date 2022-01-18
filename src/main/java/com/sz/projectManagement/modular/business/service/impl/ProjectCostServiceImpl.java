package com.sz.projectManagement.modular.business.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.rule.exception.base.ServiceException;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sz.projectManagement.core.exception.BusinessException;
import com.sz.projectManagement.modular.business.entity.ProjectCost;
import com.sz.projectManagement.modular.business.entity.User;
import com.sz.projectManagement.modular.business.enums.ProjectCostExceptionEnum;
import com.sz.projectManagement.modular.business.mapper.ProjectCostMapper;
import com.sz.projectManagement.modular.business.pojo.request.ProjectCostRequest;
import com.sz.projectManagement.modular.business.pojo.response.ProjectCostResponse;
import com.sz.projectManagement.modular.business.service.ProjectCostService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务实现层
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@Service
public class ProjectCostServiceImpl extends ServiceImpl<ProjectCostMapper, ProjectCost> implements ProjectCostService {

    private ProjectCostRequest costRequest;

    @Override
    public void add(ProjectCostRequest projectCostRequest) {

        if(projectCostRequest.getTimes()==null){
            ProjectCost projectCost = new ProjectCost();
            BeanUtil.copyProperties(projectCostRequest, projectCost);
            this.save(projectCost);
        }else if (projectCostRequest.getTimes().length > 0) {
            for (Object time : projectCostRequest.getTimes()) {
                ProjectCost projectCost = new ProjectCost();
                String strTime = time.toString().substring(0,10);
                projectCostRequest.setTime(strTime);
                BeanUtil.copyProperties(projectCostRequest, projectCost);
                this.save(projectCost);
            }
        } else if (projectCostRequest.getTimes().length == 0 && projectCostRequest.getTime() == null && projectCostRequest.getTypeCode().equals("labor_cost")) {
            throw new BusinessException(ProjectCostExceptionEnum.PROJECTCOST_ADDRENGONG_EXISTED);
        }
    }

    @Override
    public void del(ProjectCostRequest projectCostRequest) {
        ProjectCost projectCost = this.queryProjectCost(projectCostRequest);
        this.removeById(projectCost.getId());
    }

    @Override
    public void edit(ProjectCostRequest projectCostRequest) {
        ProjectCost projectCost = this.queryProjectCost(projectCostRequest);
        BeanUtil.copyProperties(projectCostRequest, projectCost);
        this.updateById(projectCost);
    }

    @Override
    public ProjectCost detail(ProjectCostRequest projectCostRequest) {
        return this.queryProjectCost(projectCostRequest);
    }

    @Override
    public PageResult<ProjectCostResponse> findPage(ProjectCostRequest projectCostRequest) {
        costRequest = projectCostRequest;
        Page<ProjectCostResponse> sysRolePage = baseMapper.pages(PageFactory.defaultPage(), projectCostRequest);
        return PageResultFactory.createPageResult(sysRolePage);
    }

    @Override
    public void downLoadExcel(HttpServletResponse response) throws IOException {
        response.addHeader("Content-Disposition", "attachment;filename=" + "project_cost.xlsx");
        response.setContentType("application/vnd.ms-excel;charset=gb2312");
        //            从HttpServletResponse中获取OutputStream输出流
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            /*
             * EasyExcel 有多个不同的read方法，适用于多种需求
             * 这里调用EasyExcel中通过OutputStream流方式输出Excel的write方法
             * 它会返回一个ExcelWriterBuilder类型的返回值
             * ExcelWriterBuilde中有一个doWrite方法，会输出数据到设置的Sheet中
             */
            List<ProjectCostResponse> list = baseMapper.list(costRequest);
            EasyExcel.write(outputStream,ProjectCostResponse.class).sheet("项目成本").doWrite(list);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            outputStream.close();
        }
    }

    @Override
    public List<ProjectCost> findList(ProjectCostRequest projectCostRequest) {
        LambdaQueryWrapper<ProjectCost> wrapper = this.createWrapper(projectCostRequest);
        return this.list(wrapper);
    }

    /**
     * 获取信息
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    private ProjectCost queryProjectCost(ProjectCostRequest projectCostRequest) {
        ProjectCost projectCost = this.getById(projectCostRequest.getId());
        if (ObjectUtil.isEmpty(projectCost)) {
            throw new ServiceException(ProjectCostExceptionEnum.PROJECTCOST_NOT_EXISTED);
        }
        return projectCost;
    }

    /**
     * 创建查询wrapper
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    private LambdaQueryWrapper<ProjectCost> createWrapper(ProjectCostRequest projectCostRequest) {
        LambdaQueryWrapper<ProjectCost> queryWrapper = new LambdaQueryWrapper<>();

        Long id = projectCostRequest.getId();
        String typeCode = projectCostRequest.getTypeCode();
        String title = projectCostRequest.getTitle();
        BigDecimal amount = projectCostRequest.getAmount();
        String remark = projectCostRequest.getRemark();
        String name = projectCostRequest.getName();
        String time = projectCostRequest.getTime();

        queryWrapper.eq(ObjectUtil.isNotNull(id), ProjectCost::getId, id);
        queryWrapper.eq(ObjectUtil.isNotNull(typeCode), ProjectCost::getTypeCode, typeCode);
        queryWrapper.like(ObjectUtil.isNotEmpty(title), ProjectCost::getTitle, title);
        queryWrapper.eq(ObjectUtil.isNotNull(amount), ProjectCost::getAmount, amount);
        queryWrapper.like(ObjectUtil.isNotEmpty(remark), ProjectCost::getRemark, remark);
        queryWrapper.like(ObjectUtil.isNotEmpty(name), ProjectCost::getName, name);
        queryWrapper.eq(ObjectUtil.isNotNull(time), ProjectCost::getTime, time);


        return queryWrapper;
    }

}
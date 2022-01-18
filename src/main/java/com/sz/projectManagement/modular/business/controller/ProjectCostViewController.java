package com.sz.projectManagement.modular.business.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 界面
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@Controller
@ApiResource(name = "界面")
public class ProjectCostViewController {

    /**
     * 首页
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "首页", path = "/view/projectCost")
    public String projectCostIndex() {
        return "/modular/business/projectCost.html";
    }

    /**
     * -新增
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "-新增", path = "/view/projectCost/add")
    public String projectCostAdd() {
        return "/modular/business/project_cost_add.html";
    }

    @GetResource(name = "-新增", path = "/view/projectCost/addrengong")
    public ModelAndView projectCostAddRengong() {
        Date today = new Date();
        List<String> dates = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            today = DateUtil.offsetDay(today, -1);
            dates.add(DateUtil.format(today, "yyyy-MM-dd  E"));
        }
        Collections.sort(dates);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/modular/business/project_cost_addrengong.html");
        modelAndView.addObject("dates", dates);
        return modelAndView;
    }

    /**
     * -编辑
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "-编辑", path = "/view/projectCost/edit")
    public String projectCostEdit() {
        return "/modular/business/project_cost_edit.html";
    }

}
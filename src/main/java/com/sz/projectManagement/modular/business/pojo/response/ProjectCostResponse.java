package com.sz.projectManagement.modular.business.pojo.response;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 封装类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */

@Data
public class ProjectCostResponse {

    /**
     * 主键
     */
    @ExcelIgnore
    @ChineseDescription("主键")
    private Long id;
    /**
     * 项目名称
     */
    @ExcelProperty("所属项目")
    @ChineseDescription("所属项目")
    private String projectName;
    /**
     * 类型
     */
    @ExcelProperty("类型")
    @ChineseDescription("类型")
    private String typeName;

    /**
     * 标题
     */
    @ExcelProperty("标题")
    @ChineseDescription("标题")
    private String title;

    /**
     * 金额
     */
    @ExcelProperty("金额")
    @ChineseDescription("金额")
    private BigDecimal amount;
    /**
     * 发生人
     */
    @ExcelProperty("发生人")
    @ChineseDescription("发生人")
    private String name;
    /**
     * 备注
     */
    @ExcelProperty("备注")
    @ChineseDescription("备注")
    private String remark;

    /**
     * 时间
     */
    @DateTimeFormat("yyyy年MM月dd日")
    @ExcelProperty("时间")
    @ChineseDescription("时间")
	private String time;


    /**
     * 进度
     */
    @ExcelIgnore
    @ChineseDescription("创建时间")
    private Date createTime;




}
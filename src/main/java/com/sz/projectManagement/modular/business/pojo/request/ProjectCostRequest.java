package com.sz.projectManagement.modular.business.pojo.request;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * 封装类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectCostRequest extends BaseRequest {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = {edit.class, delete.class})
    @ChineseDescription("主键")
    private Long id;
    /**
     * 父id
     */
    @ChineseDescription("pid")
    private Long pid;
    /**
     * 类型
     */
    @ChineseDescription("类型")
    private String typeCode;

    /**
     * 标题
     */
    @ChineseDescription("标题")
    private String title;

    /**
     * 金额
     */
    @ChineseDescription("金额")
    private BigDecimal amount;

    /**
     * 备注
     */
    @ChineseDescription("备注")
    private String remark;

    /**
     * 发生人
     */
    @ChineseDescription("发生人")
    private String name;

    /**
     * 时间
     */
    @ChineseDescription("时间")
	private String time;
    /**
     * 单价
     */
    @ChineseDescription("所有时间")
    private String[] times;

}
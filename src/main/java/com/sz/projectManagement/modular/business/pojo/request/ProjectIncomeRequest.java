package com.sz.projectManagement.modular.business.pojo.request;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.math.BigDecimal;

/**
 * 封装类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectIncomeRequest extends BaseRequest {

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
     * 合同号
     */
    @ChineseDescription("合同号")
    private String contractNumber;

    /**
     * 合同名称
     */
    @ChineseDescription("合同名称")
    private String contractName;

    /**
     * 合同类型
     */
    @ChineseDescription("合同类型")
    private String contractType;

    /**
     * 合同金额
     */
    @ChineseDescription("合同金额")
    private BigDecimal contractMoney;

    /**
     * 签订日期
     */
    @ChineseDescription("签订日期")
    private Date signDate;

    /**
     * 是否删除
     */
    @ChineseDescription("是否删除")
    private Integer deleted;

}
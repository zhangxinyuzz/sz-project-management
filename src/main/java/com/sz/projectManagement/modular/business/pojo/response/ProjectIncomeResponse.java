package com.sz.projectManagement.modular.business.pojo.response;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 封装类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectIncomeResponse extends BaseRequest {

    /**
     * 主键
     */
    @ChineseDescription("主键")
    private Long id;

    /**
     * 父id
     */
    @TableField("pid")
    private Long pid;

    /**
     * 父id
     */
    @TableField("项目名称")
    private String projectName;

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
     * 已开票金额
     */

    @ChineseDescription("已开票金额")
    private BigDecimal invoiceAmount;

    /**
     * 已回款金额
     */
    @ChineseDescription("已回款金额")
    private BigDecimal returnedMoney;
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
    /**
     * 进度
     */
    @ChineseDescription("创建时间")
    private Date createTime;


}
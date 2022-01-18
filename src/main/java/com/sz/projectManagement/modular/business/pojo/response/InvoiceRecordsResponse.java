package com.sz.projectManagement.modular.business.pojo.response;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
import com.baomidou.mybatisplus.annotation.TableField;
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
@EqualsAndHashCode(callSuper = true)
@Data
public class InvoiceRecordsResponse extends BaseRequest {

    /**
     * 主键
     */
    @ChineseDescription("主键")
    private Long id;
    /**
     * 合同名称
     */
    @ChineseDescription("合同名称")
    private String contractName;
    /**
     * 开票人
     */
    @ChineseDescription("开票人")
    private String drawer;
    /**
     * 发票编码
     */
    @ChineseDescription("发票编码")
    private String invoiceNumber;

    /**
     * 开票金额
     */
    @ChineseDescription("开票金额")
    private BigDecimal invoiceAmount;

    /**
     * 开票时间
     */
    @ChineseDescription("开票时间")
	private String invoiceTime;

    /**
     * 备注
     */
    @ChineseDescription("备注")
    private String remark;

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
    /**
     * 项目名称
     */
    @ChineseDescription("所属项目")
    private String projectName;
}
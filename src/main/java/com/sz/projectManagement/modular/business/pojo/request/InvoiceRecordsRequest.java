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
public class InvoiceRecordsRequest extends BaseRequest {

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

}
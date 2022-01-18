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
public class ReturnRecordRequest extends BaseRequest {

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
     * 回款金额
     */
    @ChineseDescription("回款金额")
    private BigDecimal returnedMoney;

    /**
     * 回款标题
     */
    @ChineseDescription("回款标题")
    private String returnedTitle;

    /**
     * 回款备注
     */
    @ChineseDescription("回款备注")
    private String remark;

    /**
     * 回款时间
     */
    @ChineseDescription("回款时间")
	private String returnedTime;

}
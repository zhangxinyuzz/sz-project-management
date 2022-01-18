package com.sz.projectManagement.modular.business.pojo.response;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
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
public class ReturnRecordResponse extends BaseRequest {

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
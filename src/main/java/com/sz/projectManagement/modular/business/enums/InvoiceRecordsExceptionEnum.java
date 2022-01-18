package com.sz.projectManagement.modular.business.enums;

import cn.stylefeng.roses.kernel.rule.constants.RuleConstants;
import cn.stylefeng.roses.kernel.rule.exception.AbstractExceptionEnum;
import lombok.Getter;

/**
 * 异常相关枚举
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@Getter
public enum InvoiceRecordsExceptionEnum implements AbstractExceptionEnum {

    /**
     * 查询结果不存在
     */
    INVOICERECORDS_NOT_EXISTED(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE +  "10001", "查询结果不存在");

    /**
     * 错误编码
     */
    private final String errorCode;

    /**
     * 提示用户信息
     */
    private final String userTip;

    InvoiceRecordsExceptionEnum(String errorCode, String userTip) {
        this.errorCode = errorCode;
        this.userTip = userTip;
    }

}
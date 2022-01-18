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
public enum ProjectCostExceptionEnum implements AbstractExceptionEnum {

    /**
     * 查询结果不存在
     */
    PROJECTCOST_NOT_EXISTED(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE +  "10001", "查询结果不存在"),
    PROJECTCOST_ADDRENGONG_EXISTED(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE +  "10002", "请勾选工时");

    /**
     * 错误编码
     */
    private final String errorCode;

    /**
     * 提示用户信息
     */
    private final String userTip;

    ProjectCostExceptionEnum(String errorCode, String userTip) {
        this.errorCode = errorCode;
        this.userTip = userTip;
    }

}
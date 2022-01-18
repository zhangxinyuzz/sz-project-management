package com.sz.projectManagement.modular.business.enums;

import cn.stylefeng.roses.kernel.rule.constants.RuleConstants;
import cn.stylefeng.roses.kernel.rule.exception.AbstractExceptionEnum;
import lombok.Getter;

/**
 * 所有项目异常相关枚举
 *
 * @author lipan
 * @date 2022/01/12 09:57
 */
@Getter
public enum ProjectExceptionEnum implements AbstractExceptionEnum {

    /**
     * 查询结果不存在
     */
    PROJECT_NOT_EXISTED(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE +  "10001", "查询结果不存在"),
    /**
     * 删除失败
     */
    PROJECT_DEL_EXISTED(RuleConstants.USER_OPERATION_ERROR_TYPE_CODE +  "10002", "项目下绑定数据");
    /**
     * 错误编码
     */
    private final String errorCode;

    /**
     * 提示用户信息
     */
    private final String userTip;

    ProjectExceptionEnum(String errorCode, String userTip) {
        this.errorCode = errorCode;
        this.userTip = userTip;
    }

}
package com.sz.projectManagement.core.exception;

import cn.stylefeng.roses.kernel.rule.exception.AbstractExceptionEnum;
import cn.stylefeng.roses.kernel.rule.exception.base.ServiceException;

import static com.sz.projectManagement.core.consts.ProjectConstants.PROJECT_MODULE_NAME;

/**
 * 业务异常
 *
 * @author lipan
 * @date 2022-01-11 15:09:18
 */
public class BusinessException extends ServiceException {

    public BusinessException(AbstractExceptionEnum exception, String userTip) {
        super(PROJECT_MODULE_NAME, exception.getErrorCode(), userTip);
    }

    public BusinessException(AbstractExceptionEnum exception) {
        super(PROJECT_MODULE_NAME, exception);
    }

}

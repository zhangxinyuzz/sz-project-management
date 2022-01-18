package com.sz.projectManagement.core.consts;

import com.sz.projectManagement.SzProjectManagementApplication;

/**
 * 项目的常量
 *
 * @author lipan
 * @date 2022-01-11 15:09:18
 */
public interface ProjectConstants {

    /**
     * 项目的模块名称
     */
    String PROJECT_MODULE_NAME = "guns-standalone";

    /**
     * 异常枚举的步进值
     */
    String BUSINESS_EXCEPTION_STEP_CODE = "100";

    /**
     * 项目的包名，例如cn.stylefeng.guns
     */
    String ROOT_PACKAGE_NAME = SzProjectManagementApplication.class.getPackage().getName();

}

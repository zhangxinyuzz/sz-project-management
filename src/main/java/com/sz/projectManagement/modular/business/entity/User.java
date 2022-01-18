package com.sz.projectManagement.modular.business.entity;

/**
 * @program: sz-project-management
 * @description:
 * @author: Mr.Li
 * @create: 2022-01-17 14:04
 **/


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;

/**
 * @program: springboot
 * @description: user
 * @author: huyuqiao
 * @create: 2021/07/04 14:53
 */
@Data
@Builder
public class User  extends BaseRowModel{

    @ExcelProperty(value = "姓名",index = 0)
    private String name;

    @ExcelProperty(value = "密码",index = 1)
    private String password;

    @ExcelProperty(value = "年龄",index = 2)
    private Integer age;
}

package com.sz.projectManagement.modular.business.entity;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.math.BigDecimal;

/**
 * 实例类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@TableName("sz_project_cost")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectCost extends BaseEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 父id
     */
    @TableField("pid")
    private Long pid;
    /**
     * 类型
     */
    @TableField("type_code")
    private String typeCode;

    /**
     * 标题
     */
    @TableField("title")
    private String title;

    /**
     * 金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 发生人
     */
    @TableField("name")
    private String name;

    /**
     * 时间
     */
    @TableField("time")
    private Date time;


    /**
     * 是否删除
     */
    @ChineseDescription("是否删除")
    private Integer deleted;


}
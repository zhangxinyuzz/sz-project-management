package com.sz.projectManagement.modular.business.entity;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sz_return_record")
@Data
@EqualsAndHashCode(callSuper = true)
public class ReturnRecord extends BaseEntity {

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
     * 回款金额
     */
    @TableField("returned_money")
    private BigDecimal returnedMoney;

    /**
     * 回款标题
     */
    @TableField("returned_title")
    private String returnedTitle;

    /**
     * 回款备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 回款时间
     */
    @TableField("returned_time")
    private Date returnedTime;
    /**
     * 是否删除
     */
    @ChineseDescription("是否删除")
    private Integer deleted;


}
package com.sz.projectManagement.modular.business.entity;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
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
@TableName("sz_project_income")
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectIncome extends BaseEntity {

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
     * 合同号
     */
    @TableField("contract_number")
    private String contractNumber;

    /**
     * 合同名称
     */
    @TableField("contract_name")
    private String contractName;

    /**
     * 合同类型
     */
    @TableField("contract_type")
    private String contractType;

    /**
     * 合同金额
     */
    @TableField("contract_money")
    private BigDecimal contractMoney;
    /**
     * 签订日期
     */
    @TableField("sign_date")
    private Date signDate;

    /**
     * 是否删除
     */
    @TableField("deleted")
    private Integer deleted;

}
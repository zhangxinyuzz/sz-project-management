package com.sz.projectManagement.modular.business.entity;

import cn.stylefeng.roses.kernel.db.api.pojo.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 所有项目实例类
 *
 * @author lipan
 * @date 2022/01/12 09:57
 */
@TableName("sz_project")
@Data
@EqualsAndHashCode(callSuper = true)
public class Project extends BaseEntity {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 客户名称
     */
    @TableField("customer_name")
    private String customerName;

    /**
     * 项目名称
     */
    @TableField("name")
    private String name;

    /**
     * 项目类型
     */
    @TableField("type")
    private String type;

    /**
     * 项目经理
     */
    @TableField("manager")
    private String manager;

    /**
     * 客户项目经理
     */
    @TableField("client_manager")
    private String clientManager;

    /**
     * 客户项目经理电话
     */
    @TableField("client_manager_phone")
    private String clientManagerPhone;

    /**
     * 项目联系人
     */
    @TableField("project_contact")
    private String projectContact;

    /**
     * 联系人电话
     */
    @TableField("project_contact_phone")
    private String projectContactPhone;

    /**
     * 项目地点
     */
    @TableField("project_location")
    private String projectLocation;

    /**
     * 项目描述
     */
    @TableField("project_description")
    private String projectDescription;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private Date endTime;

    /**
     * 状态
     */
    @TableField("state")
    private Integer state;
    /**
     * 进度
     */
    @TableField("schedule")
    private String schedule;

    /**
     * 是否删除
     */
    @TableField("deleted")
    private Boolean deleted;

}
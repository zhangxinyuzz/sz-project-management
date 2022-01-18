package com.sz.projectManagement.modular.business.pojo.response;

import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.scanner.api.annotation.field.ChineseDescription;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 所有项目封装类
 *
 * @author lipan
 * @date 2022/01/12 09:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectResponse extends BaseRequest {

    /**
     * 主键
     */
    @ChineseDescription("主键")
    private Long id;

    /**
     * 客户名称
     */
    @ChineseDescription("客户名称")
    private String customerName;

    /**
     * 项目名称
     */
    @ChineseDescription("项目名称")
    private String name;

    /**
     * 项目类型
     */

    @ChineseDescription("项目类型")
    private String typeName;

    /**
     * 项目经理
     */
    @ChineseDescription("项目经理")
    private String manager;

    /**
     * 客户项目经理
     */
    @ChineseDescription("客户项目经理")
    private String clientManager;

    /**
     * 客户项目经理电话
     */
    @ChineseDescription("客户项目经理电话")
    private String clientManagerPhone;

    /**
     * 项目联系人
     */
    @ChineseDescription("项目联系人")
    private String projectContact;

    /**
     * 联系人电话
     */
    @ChineseDescription("联系人电话")
    private String projectContactPhone;

    /**
     * 项目地点
     */
    @ChineseDescription("项目地点")
    private String projectLocation;

    /**
     * 项目描述
     */
    @ChineseDescription("项目描述")
    private String projectDescription;

    /**
     * 备注
     */
    @ChineseDescription("备注")
    private String remark;

    /**
     * 开始时间
     */
    @ChineseDescription("开始时间")
	private String startTime;

    /**
     * 结束时间
     */
    @ChineseDescription("结束时间")
	private String endTime;


    /**
     * 状态
     */
    @ChineseDescription("状态")
    private Integer state;
    /**
     * 进度
     */
    @ChineseDescription("项目进度")
    private String schedule;
    /**
     * 进度
     */
    @ChineseDescription("创建时间")
    private Date createTime;



}
package com.sz.projectManagement.modular.business.service;

import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.sz.projectManagement.modular.business.entity.ReturnRecord;
import com.sz.projectManagement.modular.business.pojo.request.ReturnRecordRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sz.projectManagement.modular.business.pojo.response.ReturnRecordResponse;

import java.util.List;

/**
 *  服务类
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
public interface ReturnRecordService extends IService<ReturnRecord> {

	/**
     * 新增
     *
     * @param returnRecordRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void add(ReturnRecordRequest returnRecordRequest);

	/**
     * 删除
     *
     * @param returnRecordRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void del(ReturnRecordRequest returnRecordRequest);

	/**
     * 编辑
     *
     * @param returnRecordRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    void edit(ReturnRecordRequest returnRecordRequest);

	/**
     * 查询详情
     *
     * @param returnRecordRequest 请求参数
     * @author lipan
     * @date 2022/01/11 15:17
     */
    ReturnRecord detail(ReturnRecordRequest returnRecordRequest);

	/**
     * 获取列表
     *
     * @param returnRecordRequest        请求参数
     * @return List<ReturnRecord>   返回结果
     * @author lipan
     * @date 2022/01/11 15:17
     */
    List<ReturnRecord> findList(ReturnRecordRequest returnRecordRequest);

	/**
     * 获取列表（带分页）
     *
     * @param returnRecordRequest              请求参数
     * @return PageResult<ReturnRecord>   返回结果
     * @author lipan
     * @date 2022/01/11 15:17
     */
    PageResult<ReturnRecordResponse> findPage(ReturnRecordRequest returnRecordRequest);

}
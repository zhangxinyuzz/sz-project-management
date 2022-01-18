package com.sz.projectManagement.modular.business.controller;

import com.sz.projectManagement.modular.business.pojo.request.ReturnRecordRequest;
import com.sz.projectManagement.modular.business.service.ReturnRecordService;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 控制器
 *
 * @author lipan
 * @date 2022/01/11 15:17
 */
@RestController
@ApiResource(name = "")
public class ReturnRecordController {

    @Resource
    private ReturnRecordService returnRecordService;

    /**
     * 添加
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "添加", path = "/returnRecord/add")
    public ResponseData add(@RequestBody @Validated(ReturnRecordRequest.add.class) ReturnRecordRequest returnRecordRequest) {
        returnRecordService.add(returnRecordRequest);
        return new SuccessResponseData();
    }

    /**
     * 删除
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "删除", path = "/returnRecord/delete")
    public ResponseData delete(@RequestBody @Validated(ReturnRecordRequest.delete.class) ReturnRecordRequest returnRecordRequest) {
        returnRecordService.del(returnRecordRequest);
        return new SuccessResponseData();
    }

    /**
     * 编辑
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @PostResource(name = "编辑", path = "/returnRecord/edit")
    public ResponseData edit(@RequestBody @Validated(ReturnRecordRequest.edit.class) ReturnRecordRequest returnRecordRequest) {
        returnRecordService.edit(returnRecordRequest);
        return new SuccessResponseData();
    }

    /**
     * 查看详情
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "查看详情", path = "/returnRecord/detail")
    public ResponseData detail(@Validated(ReturnRecordRequest.detail.class) ReturnRecordRequest returnRecordRequest) {
        return new SuccessResponseData(returnRecordService.detail(returnRecordRequest));
    }

    /**
     * 获取列表
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "获取列表", path = "/returnRecord/list")
    public ResponseData list(ReturnRecordRequest returnRecordRequest) {
        return new SuccessResponseData(returnRecordService.findList(returnRecordRequest));
    }

    /**
     * 获取列表（带分页）
     *
     * @author lipan
     * @date 2022/01/11 15:17
     */
    @GetResource(name = "分页查询", path = "/returnRecord/page")
    public ResponseData page(ReturnRecordRequest returnRecordRequest) {
        return new SuccessResponseData(returnRecordService.findPage(returnRecordRequest));
    }

}
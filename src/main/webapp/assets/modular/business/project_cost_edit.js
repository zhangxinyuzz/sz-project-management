/**
 * 编辑
 */
layui.use(['form', 'admin', 'laydate', 'HttpRequest','gunsSelect','laydate'], function () {
    var form = layui.form;
    var admin = layui.admin;
    var HttpRequest = layui.HttpRequest;
    var laydate = layui.laydate;
    var $ = layui.jquery;
    var gunsSelect = layui.gunsSelect;
    // 渲染时间选择框
    laydate.render({
        elem: '#time'
    });
    gunsSelect.render({
        url: Feng.ctxPath + '/project/list',
        elem: '#pid',
        fields: {name: 'name', value: 'id'},
    });


   /* // 监听 人工成本labor_cost
    $(document).ready(function () {
        // select下拉框选中触发事件
        form.on("select", function (data) {

            if (data.value === 'labor_cost') {
                if (typeof ($("#manHour")[0]) === 'undefined' && typeof ($("#unitPrice")[0]) === 'undefined') {
                    $("#cost").append(`
                    <div class="layui-inline layui-col-md12" id="manHourDiv">
                        <label class="layui-form-label layui-form-required">工时(天)</label>
                        <div class="layui-input-block">
                        <input id="manHour" name="manHour" placeholder="请输入工时(天)" type="text" class="layui-input" autocomplete="off" lay-verify="required" required/>
                        </div>
                        </div>
                     <div class="layui-inline layui-col-md12" id="unitPriceDiv">
                        <label class="layui-form-label layui-form-required">单价</label>
                        <div class="layui-input-block">
                        <input id="unitPrice" name="unitPrice" placeholder="请输入单价" type="text" class="layui-input" autocomplete="off" lay-verify="required" required/>
                        </div>
                      </div>
                `)
                    result.data.typeCode = 'labor_cost';
                    form.val('projectCostForm', result.data);
                }
            } else {
                $("#manHourDiv").remove();
                $("#unitPriceDiv").remove();
            }
        });
    });
*/
    // 成本类型
    gunsSelect.render({
        url: Feng.ctxPath + '/dict/list',
        elem: '#typeCode',
        fields: {name: 'dictName', value: 'dictCode'},
        where: {dictTypeCode: 'project_cost_type'}
    });
    // 获取详情
    var request = new HttpRequest(Feng.ctxPath + "/projectCost/detail?id=" + Feng.getUrlParam("id"), 'get');
    var result = request.start();

    if (result.data.manHour == null || result.data.unitPrice == null) {
        $("#manHourDiv").remove();
        $("#unitPriceDiv").remove();
    }

    form.val('projectCostForm', result.data);


    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var request = new HttpRequest(Feng.ctxPath + "/projectCost/edit", 'post', function (data) {
            Feng.success("修改成功!");
            admin.putTempData('formOk', true);
            admin.closeThisDialog();
        }, function (data) {
            Feng.error("修改失败!" + data.message);
            admin.closeThisDialog();
        });
        request.set(data.field);
        request.start(true);
    });

});
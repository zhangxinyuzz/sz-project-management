/**
 * 添加
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
        elem: '#invoiceTime'
    });
    // 合同类型
    gunsSelect.render({
        url: Feng.ctxPath + '/projectIncome/list',
        elem: '#pid',
        fields: {name: 'contractName', value: 'id'},
    });
    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var request = new HttpRequest(Feng.ctxPath + "/invoiceRecords/add", 'post', function (data) {
            admin.closeThisDialog();
            Feng.success("添加成功！");
            admin.putTempData('formOk', true);
        }, function (data) {
            admin.closeThisDialog();
            Feng.error("添加失败！" + data.message);
        });
        request.set(data.field);
        request.start(true);
    });

});
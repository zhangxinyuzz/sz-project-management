/**
 * 编辑
 */
layui.use(['form', 'admin', 'laydate', 'HttpRequest'], function () {
    var form = layui.form;
    var admin = layui.admin;
    var HttpRequest = layui.HttpRequest;
    var laydate = layui.laydate;
    var $ = layui.jquery;

    // 获取详情
    var request = new HttpRequest(Feng.ctxPath + "/invoiceRecords/detail?id=" + Feng.getUrlParam("id"), 'get');
    var result = request.start();

    form.val('invoiceRecordsForm', result.data);


    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var request = new HttpRequest(Feng.ctxPath + "/invoiceRecords/edit", 'post', function (data) {
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
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
        elem: '#time'
    });
    gunsSelect.render({
        url: Feng.ctxPath + '/project/list',
        elem: '#pid',
        fields: {name: 'name', value: 'id'},
    });



    // 成本类型
    gunsSelect.render({
        url: Feng.ctxPath + '/dict/list',
        elem: '#typeCode',
        fields: {name: 'dictName', value: 'dictCode'},
        where: {dictTypeCode: 'project_cost_type'}
    });
    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {

        var request = new HttpRequest(Feng.ctxPath + "/projectCost/add", 'post', function (data) {
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
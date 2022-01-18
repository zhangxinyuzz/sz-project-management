layui.use(['table', 'HttpRequest', 'func', 'form', 'laydate', 'gunsSelect'], function () {
    var $ = layui.$;
    var table = layui.table;
    var HttpRequest = layui.HttpRequest;
    var func = layui.func;
    var form = layui.form;
    var laydate = layui.laydate;
    var gunsSelect = layui.gunsSelect;

    /**
     * 初始化参数
     */
    var ReturnRecord = {
        tableId: "returnRecordTable"
    };

    /**
     * 初始化表格的列
     */
    ReturnRecord.initColumn = function () {
        return [[
            {type: 'radio'},
			{field: 'id', hide: true, title: '主键'},
            {field: 'projectName', sort: true, align: "center", title: '所属项目'},
            {field: 'contractName', sort: true, align: "center", title: '所属合同'},
			{field: 'returnedMoney', sort: true, align: "center", title: '回款金额'},
			{field: 'returnedTitle', sort: true, align: "center", title: '回款标题'},
			{field: 'remark', sort: true, align: "center", title: '回款备注'},
			{field: 'returnedTime', sort: true, align: "center", title: '回款时间',templet : "<div>{{layui.util.toDateString(d.returnedTime, 'yyyy-MM-dd')}}</div>"},
            {field: 'createTime', sort: true, align: "center", title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    ReturnRecord.search = function () {
        var queryData = {};
        queryData['returnedMoney'] = $("#returnedMoney").val();
        queryData['returnedTitle'] = $("#returnedTitle").val();
        queryData['remark'] = $("#remark").val();
        queryData['returnedTime'] = $("#returnedTime").val();
        queryData['createUser'] = $("#createUser").val();
        queryData['createTime'] = $("#createTime").val();
        queryData['updateUser'] = $("#updateUser").val();
        queryData['updateTime'] = $("#updateTime").val();
        table.reload(ReturnRecord.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 添加对话框
     */
    ReturnRecord.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/view/returnRecord/add',
            tableId: ReturnRecord.tableId
        });
    };

    /**
     * 编辑对话框
     *
     * @param data 点击按钮时候的行数据
     */
    ReturnRecord.openEditDlg = function (data) {
        func.open({
            title: '修改',
			content: Feng.ctxPath + '/view/returnRecord/edit?id=' + data.id,
            tableId: ReturnRecord.tableId
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    ReturnRecord.onDeleteItem = function (data) {
        var operation = function () {
            var request = new HttpRequest(Feng.ctxPath + "/returnRecord/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(ReturnRecord.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
			request.set("id", data.id);
            request.start(true);
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + ReturnRecord.tableId,
        url: Feng.ctxPath + '/returnRecord/page',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: ReturnRecord.initColumn(),
        request: {pageName: 'pageNo', limitName: 'pageSize'},
        parseData: Feng.parseData
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        ReturnRecord.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        ReturnRecord.openAddDlg();
    });

    // 工具条点击事件
    table.on('tool(' + ReturnRecord.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            ReturnRecord.openEditDlg(data);
        } else if (layEvent === 'delete') {
            ReturnRecord.onDeleteItem(data);
        }
    });

});
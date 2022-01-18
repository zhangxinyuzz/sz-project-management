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
    var InvoiceRecords = {
        tableId: "invoiceRecordsTable"
    };

    /**
     * 初始化表格的列
     */
    InvoiceRecords.initColumn = function () {
        return [[
            {type: 'radio'},
			{field: 'id', hide: true, title: '主键'},
            {field: 'projectName', sort: true, align: "center", title: '所属项目'},
            {field: 'contractName', sort: true, align: "center", title: '所属合同'},
			{field: 'drawer', sort: true, align: "center", title: '开票人'},
			{field: 'invoiceNumber', sort: true, align: "center", title: '发票编码'},
			{field: 'invoiceAmount', sort: true, align: "center", title: '开票金额'},
			{field: 'invoiceTime', sort: true, align: "center", title: '开票时间',templet : "<div>{{layui.util.toDateString(d.invoiceTime, 'yyyy-MM-dd')}}</div>"},
            {field: 'createTime', sort: true, align: "center", title: '创建时间'},
			{field: 'remark', sort: true, align: "center", title: '备注'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    InvoiceRecords.search = function () {
        var queryData = {};
        queryData['drawer'] = $("#drawer").val();
        queryData['invoiceNumber'] = $("#invoiceNumber").val();
        queryData['invoiceAmount'] = $("#invoiceAmount").val();
        queryData['invoiceTime'] = $("#invoiceTime").val();
        queryData['remark'] = $("#remark").val();
        queryData['createUser'] = $("#createUser").val();
        queryData['createTime'] = $("#createTime").val();
        queryData['updateUser'] = $("#updateUser").val();
        queryData['updateTime'] = $("#updateTime").val();
        table.reload(InvoiceRecords.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 添加对话框
     */
    InvoiceRecords.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/view/invoiceRecords/add',
            tableId: InvoiceRecords.tableId
        });
    };

    /**
     * 编辑对话框
     *
     * @param data 点击按钮时候的行数据
     */
    InvoiceRecords.openEditDlg = function (data) {
        func.open({
            title: '修改',
			content: Feng.ctxPath + '/view/invoiceRecords/edit?id=' + data.id,
            tableId: InvoiceRecords.tableId
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    InvoiceRecords.onDeleteItem = function (data) {
        var operation = function () {
            var request = new HttpRequest(Feng.ctxPath + "/invoiceRecords/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(InvoiceRecords.tableId);
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
        elem: '#' + InvoiceRecords.tableId,
        url: Feng.ctxPath + '/invoiceRecords/page',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: InvoiceRecords.initColumn(),
        request: {pageName: 'pageNo', limitName: 'pageSize'},
        parseData: Feng.parseData
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        InvoiceRecords.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        InvoiceRecords.openAddDlg();
    });

    // 工具条点击事件
    table.on('tool(' + InvoiceRecords.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            InvoiceRecords.openEditDlg(data);
        } else if (layEvent === 'delete') {
            InvoiceRecords.onDeleteItem(data);
        }
    });

});
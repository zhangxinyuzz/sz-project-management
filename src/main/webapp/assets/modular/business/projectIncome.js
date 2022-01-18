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
    var ProjectIncome = {
        tableId: "projectIncomeTable"
    };

    /**
     * 初始化表格的列
     */
    ProjectIncome.initColumn = function () {
        return [[
            {type: 'radio'},
			{field: 'id', hide: true, title: '主键'},
            {field: 'projectName', sort: true, align: "center", title: '所属项目'},
			{field: 'contractNumber', sort: true, align: "center", title: '合同号'},
			{field: 'contractName', sort: true, align: "center", title: '合同名称'},
			{field: 'contractType', sort: true, align: "center", title: '合同类型'},
			{field: 'contractMoney', sort: true, align: "center", title: '合同金额'},
			{field: 'invoiceAmount', sort: true, align: "center", title: '已开票金额'},
			{field: 'returnedMoney', sort: true, align: "center", title: '已回款金额'},
            {field: 'signDate', sort: true, align: "center", title: '签订日期'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    ProjectIncome.search = function () {
        var queryData = {};
        queryData['contractNumber'] = $("#contractNumber").val();
        queryData['contractName'] = $("#contractName").val();
        queryData['contractType'] = $("#contractType").val();
        queryData['contractMoney'] = $("#contractMoney").val();
        queryData['amountInvoiced'] = $("#amountInvoiced").val();
        queryData['amountCashed'] = $("#amountCashed").val();
        queryData['deleted'] = $("#deleted").val();
        queryData['createUser'] = $("#createUser").val();
        queryData['createTime'] = $("#createTime").val();
        queryData['updateUser'] = $("#updateUser").val();
        queryData['updateTime'] = $("#updateTime").val();
        table.reload(ProjectIncome.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 添加对话框
     */
    ProjectIncome.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/view/projectIncome/add',
            tableId: ProjectIncome.tableId
        });
    };

    /**
     * 编辑对话框
     *
     * @param data 点击按钮时候的行数据
     */
    ProjectIncome.openEditDlg = function (data) {
        func.open({
            title: '修改',
			content: Feng.ctxPath + '/view/projectIncome/edit?id=' + data.id,
            tableId: ProjectIncome.tableId
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    ProjectIncome.onDeleteItem = function (data) {
        var operation = function () {
            var request = new HttpRequest(Feng.ctxPath + "/projectIncome/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(ProjectIncome.tableId);
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
        elem: '#' + ProjectIncome.tableId,
        url: Feng.ctxPath + '/projectIncome/page',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: ProjectIncome.initColumn(),
        request: {pageName: 'pageNo', limitName: 'pageSize'},
        parseData: Feng.parseData
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        ProjectIncome.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        ProjectIncome.openAddDlg();
    });

    // 工具条点击事件
    table.on('tool(' + ProjectIncome.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            ProjectIncome.openEditDlg(data);
        } else if (layEvent === 'delete') {
            ProjectIncome.onDeleteItem(data);
        }
    });

});
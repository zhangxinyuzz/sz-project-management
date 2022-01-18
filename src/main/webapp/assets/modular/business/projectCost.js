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
    var ProjectCost = {
        tableId: "projectCostTable"
    };

    /**
     * 初始化表格的列
     */
    ProjectCost.initColumn = function () {
        return [[
            {type: 'radio'},
            {field: 'id', hide: true, title: '主键'},
            {field: 'projectName', sort: true, align: "center", title: '所属项目'},
            {field: 'typeName', sort: true, align: "center", title: '类型'},
            {field: 'title', sort: true, align: "center", title: '标题'},
            {field: 'amount', sort: true, align: "center", title: '金额'},
            {field: 'remark', sort: true, align: "center", title: '备注'},
            {field: 'name', sort: true, align: "center", title: '发生人'},
            {
                field: 'time',
                sort: true,
                align: "center",
                title: '时间',
                templet: "<div>{{layui.util.toDateString(d.time, 'yyyy-MM-dd')}}</div>"
            },
            {field: 'createTime', sort: true, align: "center", title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    ProjectCost.search = function () {
        var queryData = {};
        queryData['typeCode'] = $("#typeCode").val();
        queryData['title'] = $("#title").val();
        queryData['amount'] = $("#amount").val();
        queryData['remark'] = $("#remark").val();
        queryData['name'] = $("#name").val();
        queryData['time'] = $("#time").val();
        queryData['manHour'] = $("#manHour").val();
        queryData['unitPrice'] = $("#unitPrice").val();
        queryData['createUser'] = $("#createUser").val();
        queryData['createTime'] = $("#createTime").val();
        queryData['updateUser'] = $("#updateUser").val();
        queryData['updateTime'] = $("#updateTime").val();
        table.reload(ProjectCost.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 添加对话框
     */
    ProjectCost.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/view/projectCost/add',
            tableId: ProjectCost.tableId
        });
    };

    ProjectCost.openAddRengongDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/view/projectCost/addrengong',
            tableId: ProjectCost.tableId
        });
    };

    /**
     * 编辑对话框
     *
     * @param data 点击按钮时候的行数据
     */
    ProjectCost.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/view/projectCost/edit?id=' + data.id,
            tableId: ProjectCost.tableId
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    ProjectCost.onDeleteItem = function (data) {
        var operation = function () {
            var request = new HttpRequest(Feng.ctxPath + "/projectCost/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(ProjectCost.tableId);
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
        elem: '#' + ProjectCost.tableId,
        url: Feng.ctxPath + '/projectCost/page',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: ProjectCost.initColumn(),
        request: {pageName: 'pageNo', limitName: 'pageSize'},
        parseData: Feng.parseData
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        ProjectCost.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        ProjectCost.openAddDlg();
    });

    // 添加按钮点击事件
    $('#btnAddRengong').click(function () {
        ProjectCost.openAddRengongDlg();
    });

    // 工具条点击事件
    table.on('tool(' + ProjectCost.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            ProjectCost.openEditDlg(data);
        } else if (layEvent === 'delete') {
            ProjectCost.onDeleteItem(data);
        }
    });

    // 导出excel按钮
    ProjectCost.exportExcel = function () {
        /*$.ajax({
            type:'POST',
            url: Feng.ctxPath + '/projectCost/down',
           /!* data: params,*!/
            success: function(redata) {

                // 创建a标签，设置属性，并触发点击下载
                var $a = $("<a>");
                $a.attr(Feng.ctxPath + '/projectCost/down', redata.data.file);
                $a.attr("download", redata.data.filename);
                $("body").append($a);
                $a[0].click();
                $a.remove();
            }
        });*/
        window.open(Feng.ctxPath + '/projectCost/down');
    };

    // 导出excel
    $('#btnExp').click(function () {
        ProjectCost.exportExcel();
    });

});
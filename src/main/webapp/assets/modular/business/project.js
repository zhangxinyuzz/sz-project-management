layui.use(['table', 'HttpRequest', 'func', 'form', 'laydate', 'gunsSelect','layer'], function () {
    var $ = layui.$;
    var table = layui.table;
    var HttpRequest = layui.HttpRequest;
    var func = layui.func;
    var form = layui.form;
    var laydate = layui.laydate;
    var gunsSelect = layui.gunsSelect;
    var layer = layui.layer;

    // 项目类型
    gunsSelect.render({
        url: Feng.ctxPath + '/dict/list',
        elem: '#type',
        fields: {name: 'dictName', value: 'dictCode'},
        where: {dictTypeCode: 'project_type'}
    });
    /**
     * 初始化参数
     */
    var Project = {
        tableId: "projectTable"
    };

    /**
     * 初始化表格的列
     */
    Project.initColumn = function () {
        return [[
            {type: 'radio'},
			{field: 'id', hide: true, title: '主键'},
			{field: 'customerName', sort: true, align: "center", title: '客户名称'},
			{field: 'name', sort: true, align: "center", title: '项目名称'},
			{field: 'typeName', sort: true, align: "center", title: '项目类型'},
			{field: 'projectLocation', sort: true, align: "center", title: '项目地点'},
			{field: 'startTime', sort: true, align: "center", title: '开始时间',templet : "<div>{{layui.util.toDateString(d.startTime, 'yyyy-MM-dd')}}</div>"},
			{field: 'endTime', sort: true, align: "center", title: '结束时间',templet : "<div>{{layui.util.toDateString(d.endTime, 'yyyy-MM-dd')}}</div>"},
            {field: 'schedule', sort: true, align: "center", title: '项目进度'},
			{field: 'state', sort: true, align: "center", title: '状态',
                templet: function (d) {//对每列数据进行处理后展示
                    if (d.state===0) {
                        return "未开始"
                    } else if(d.state===1) {
                        return "进行中"
                    } else if(d.state===2){
                        return "已结束"
                    }
                }},
            {field: 'createTime', sort: true, align: "center", title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作',width: 160}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Project.search = function () {
        var queryData = {};
        queryData['customerName'] = $("#customerName").val();
        queryData['name'] = $("#name").val();
        queryData['type'] = $("#type").val();
        queryData['manager'] = $("#manager").val();
        queryData['clientManager'] = $("#clientManager").val();
        queryData['clientManagerPhone'] = $("#clientManagerPhone").val();
        queryData['projectContact'] = $("#projectContact").val();
        queryData['projectContactPhone'] = $("#projectContactPhone").val();
        queryData['projectLocation'] = $("#projectLocation").val();
        queryData['projectDescription'] = $("#projectDescription").val();
        queryData['remark'] = $("#remark").val();
        queryData['startTime'] = $("#startTime").val();
        queryData['endTime'] = $("#endTime").val();
        queryData['state'] = $("#state").val();
        queryData['subTheme'] = $("#subTheme").val();
        queryData['deleted'] = $("#deleted").val();
        queryData['createUser'] = $("#createUser").val();
        queryData['createTime'] = $("#createTime").val();
        queryData['updateUser'] = $("#updateUser").val();
        queryData['updateTime'] = $("#updateTime").val();
        table.reload(Project.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 添加对话框
     */
    Project.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/view/project/add',
            tableId: Project.tableId
        });
    };

    /**
     * 编辑对话框
     *
     * @param data 点击按钮时候的行数据
     */
    Project.openEditDlg = function (data) {
        func.open({
            title: '修改',
			content: Feng.ctxPath + '/view/project/edit?id=' + data.id,
            tableId: Project.tableId
        });
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Project.onDeleteItem = function (data) {
        var operation = function () {
            var request = new HttpRequest(Feng.ctxPath + "/project/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(Project.tableId);
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
        elem: '#' + Project.tableId,
        url: Feng.ctxPath + '/project/page',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Project.initColumn(),
        request: {pageName: 'pageNo', limitName: 'pageSize'},
        parseData: Feng.parseData
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Project.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Project.openAddDlg();
    });

    // 工具条点击事件
    table.on('tool(' + Project.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Project.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Project.onDeleteItem(data);
        } else if (layEvent === 'detail') {
            Project.openDetailDlg(data);
        }
    });
    /**
     * 编辑对话框
     *
     * @param data 点击按钮时候的行数据
     */
    Project.openDetailDlg = function (data) {

        layer.open({
            anim: 2,
            type: 2,
            title: '项目详情',
            shadeClose: true,
            shade: 0.3,
            area : ['100%' , '100%'],
            content: Feng.ctxPath + '/view/project/detail?id=' + data.id, //这里content是一个URL，
        });
    };

});

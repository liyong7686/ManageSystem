<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->

${config.headStr}

${config.layuiStr}

<!-- 加入移动布局 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no"/>
<!-- 加入移动布局 -->

<!-- 引入manage 的基础css -->
<script	src="${pageContext.request.contextPath}/static/common/manage/manage_base.js"></script>
<link href="${pageContext.request.contextPath}/static/common/manage/manage_base.css" rel="stylesheet"/>
<!-- 引入manage 的基础css -->

</head>
<style>

/*修改table表格  左右内边框 为0*/
.layui-table-cell {
	padding-left: 0px;
	padding-right: 0px;
	text-align: center;
}
/*修改table表格 左右内边框 为0*/

</style>
<body>
<script>
var global_ids;
var global_ids_len;

var w ;//窗口的宽
var h ;//窗口的高

function add(){
	w = 700;
	h = 800;
	checkWindow();
	
	layer.open({
	  type: 2,
	  title: '添加',
	  shadeClose: true,
	  shade: 0.8,
	  area: [w+'px', h+'px'],
	  content: '/houtai/book/add'  //iframe的url
	});
}

//打开编辑窗口
function edit(id){
	w = 700;
	h = 800;
	checkWindow();
	
	layer.open({
	  type: 2,
	  title: '修改',
	  shadeClose: true,
	  shade: 0.8,
	  area: [w+'px', h+'px'],
	  content: '/houtai/book/edit?id='+id //iframe的url
	});
}

//子窗口调用 的  关闭窗口方法 
function closeDlg(msg){
	 layer.closeAll();
	 layer.msg(msg);
	 reload_data();
}

//相当前刷新  重新加载
function reload_data(){
	var q  = $("#q").val();
	table.reload('table', {
		 where: {q:q},page:{curr: 1}
    });
}

function del(ids){
	var index = layer.load(1, {
		  shade: [0.1,'#fff'] //0.1透明度的白色背景
	});
	$.post('/admin/book/delete',{ids:ids},function(result){
		if(result.success){
			layer.closeAll();
			layer.msg('删除成功');
			reload_data();
		}else{
			layer.closeAll();
			layer.msg(result.msg);
		}
	},'json');
}

</script>

<div class="layui-form" style="min-width:1000px;">

<div class="layui-table-toolbar" style="margin-bottom: 3px; ">
	<div class="layui-btn-group">
		<button onclick="add()" class="layui-btn  layui-btn-sm">增加图书</button>
		<button class="layui-btn layui-btn-sm" onclick="delSelected()"><i class="layui-icon">&#xe640;</i>删除选中项</button>
	    <button class="layui-btn layui-btn-sm" onclick="reload_data()"><i class="layui-icon">&#x1002;</i>刷新</button>
 	 </div>
</div>

<div class="layui-form layui-form-pane" style="margin-bottom: 3px; "  >
	<div class="layui-form-item" style="margin-bottom: 1px; min-width:1051px;">
		<label class="layui-form-label">模糊搜索</label>
		<div class="layui-input-inline">
			<input type="text" id="q" onkeydown="if(event.keyCode==13) reload_data()"  name="title" lay-verify="title" autocomplete="off" placeholder="模糊搜索" class="layui-input">
		</div>
	    <div class="layui-input-inline" style="  width: 113px;">
	    	<a class="layui-btn" onclick="reload_data()">查询</a>
	    </div>
    </div>
</div>

<table class="layui-hide"   id="table" lay-filter="table"></table> 

<script type="text/html" id="table_bar">
<div class="layui-btn-group">
	<a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
</div>
</script>

<script>
		layui.use([ 'laydate', 'laypage', 'layer', 'table', 'carousel',
				'upload', 'element' ], function() {
			var laydate = layui.laydate //日期
			, laypage = layui.laypage //分页
			layer = layui.layer //弹层
			, table = layui.table //表格
			, carousel = layui.carousel //轮播
			, upload = layui.upload //上传
			, element = layui.element; //元素操作
			  table.render({
			    elem: '#table'
			    ,url: '/admin/book/list',
			    height: 'full-160',
			   cols: [[
			           
			       {checkbox: true, width:50, fixed: true}
			      ,{field:'bianhao', title: '图书编号', width:80 ,style:'font-size: 12px; '}
			      ,{field:'name', title: '书名', width:120,  style:'font-size: 12px;'}
			      ,{field:'banhao', title: '出版书号', width:80,  style:'font-size: 12px;'  }
			      ,{field:'bianzhu', title: '编著者', width:120,  style:'font-size: 12px;'  }
			      ,{field:'chubanshe', title: '出版社', width:80,  style:'font-size: 12px;' }
			      ,{field:'chubanDate', title: '出版日期', width:80,  style:'font-size: 12px;'}
			      ,{field:'danjia', title: '单价', width:80,  style:'font-size: 12px;'}
			      ,{field:'kucun', title: '库存数量 ', width:130,style:'font-size: 12px;'}
			      
			      ,{fixed:'right', width:80,title: '操作',  toolbar: '#table_bar'}
			    	
			      
			    ]]
			    ,id: 'table'
			    ,page: true
			    ,limits:[10,50,100,200,500,1000],
			   limit:100
			  });
			
			/*
			//常规用法
			  laydate.render({
			    elem: '#date1'
			  });
			//常规用法
			  laydate.render({
			    elem: '#date2'
			  });
			*/
			
			//监听工具条 table_bar
				table.on('tool(table)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
					var data = obj.data //获得当前行数据
					, layEvent = obj.event; //获得 lay-event 对应的值
					if (layEvent === 'add_send_list') {
						//layer.msg('查看操作' + data.id);
						add_send_list(data.id)
					} else if (layEvent === 'see') {
						see(data.id);
					} else if (layEvent === 'edit') {
						//layer.msg('编辑操作' + data.id);
						edit(data.id);
					} else if(layEvent === 'refund'){
						refund_dlg(data.id);
					}else if(layEvent ==='see_wxuser_info'){
					}

				});
			
			
				//日期时间选择器
				  laydate.render({
				    elem: '#startDateTime'
				    ,type: 'datetime'
				  });
				  laydate.render({
				    elem: '#endDateTime'
				    ,type: 'datetime'
				  });
				
		});
</script>


</body>
</html>

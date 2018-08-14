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

function return_(userSubId){
	//询问框
	layer.confirm('您是否要归还此书？', {
	  btn: ['是','取消'] //按钮
	}, function(){
		
		$.post("/admin/user/sub/return_",{subId:userSubId},function(result){
			if(result.success){
				layer.closeAll();
				layer.msg(result.msg);
				
				reload_data();
			}else{
				layer.closeAll();//关闭loading
				layer.msg(result.msg);
			}
		},'json');
		
	}, function(){
		layer.closeAll();//关闭loading
		layer.msg('您选择是取消');
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
	table.reload('table', {
		 where: {},page:{curr: 1}
    });
}
</script>

<div class="layui-form" style="min-width:1000px;">

<div class="layui-table-toolbar" style="margin-bottom: 3px; ">
	<div class="layui-btn-group">
	    <button class="layui-btn layui-btn-sm" onclick="reload_data()"><i class="layui-icon">&#x1002;</i>刷新</button>
 	 </div>
</div>


<table class="layui-hide"   id="table" lay-filter="table"></table> 


<script type="text/html" id="format_user_name">
  {{#  if(d.userId!= null){ }}
	 {{d.user.trueName}} 
  {{#  } else { }}
  {{#  } }}
</script>


<script type="text/html" id="format_user_num">
  {{#  if(d.userId!= null){ }}
	 {{d.user.num_}} 
  {{#  } else { }}
  {{#  } }}
</script>

<script type="text/html" id="format_book_bianhao">
  {{#  if(d.bookId!= null){ }}
	 {{d.book.bianhao}} 
  {{#  } else { }}
  {{#  } }}
</script>


<script type="text/html" id="format_book_name">
  {{#  if(d.bookId!= null){ }}
	 {{d.book.name}} 
  {{#  } else { }}
  {{#  } }}
</script>

<script type="text/html" id="format_type">
  {{#  if(d.type== 1){ }}
		未还
  {{#  } else { }}
		已还
  {{#  } }}
</script>



<script type="text/html" id="table_bar">
<div class="layui-btn-group">
	<a class="layui-btn layui-btn-xs" lay-event="return_">归还此书</a>
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
			    ,url: '${table_url}',
			    height: 'full-160',
			   cols: [[
					
			       {checkbox: true, width:50, fixed: true}
			       ,{field:'userId', title: '读者号', width:80 ,style:'font-size: 12px;',templet: '#format_user_num'}
			      ,{field:'userId', title: '借阅人姓名', width:80 ,style:'font-size: 12px;',templet: '#format_user_name'}
			      
			      ,{field:'bookId', title: '图书编号', width:120,  style:'font-size: 12px;',templet: '#format_book_bianhao'}
			      ,{field:'bookId', title: '书名', width:120,  style:'font-size: 12px;',templet: '#format_book_name'}
			      ,{field:'type', title: '状态', width:120,  style:'font-size: 12px;',templet: '#format_type'}
			      
			      
			      ,{field:'subDateTime', title: '借阅时间', width:180,  style:'font-size: 12px;'}
			      ,{field:'returnDateTime', title: '归还时间', width:180,  style:'font-size: 12px;'}
			      
			      ,{fixed:'right', width:80,title: '操作',  toolbar: '#table_bar'}
			    	
			      
			    ]]
			    ,id: 'table'
			    ,page: true
			    ,limits:[10,50,100,200,500,1000],
			   limit:100
			  });
			
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
					} else if(layEvent === 'return_'){
						return_(data.id);
					}else if(layEvent ==='see_wxuser_info'){
					}
					
					
				});
			
				//常规用法
				  laydate.render({
				    elem: '#startDateTime'
				  });
				
				//常规用法
				  laydate.render({
				    elem: '#endDateTime'
				  });
		});
</script>


</body>
</html>

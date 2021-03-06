<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- JSTL -->

${config.headStr}

${config.layuiStr}

<!-- 加入移动布局 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no" />
<!-- 加入移动布局 -->

<script>
var save_url = '${save_url}';

function save() {
	//loading
	var index = layer.load(1, {
		shade : [ 0.1, '#fff' ]
		//0.1透明度的白色背景
	});
	
	var content = $("#content").val();
	if(content.length<1){
		layer.closeAll();
		layer.msg('请输入留言内容', {icon: 2});
		return;
	}
	
	$.post(save_url, {
		content : content
	}, function(result) {
		if (result.success) {
			//调用 父窗口的  关闭所有窗口 并且刷新 页面
			window.parent.closeDlg(result.msg);
		} else {
			layer.closeAll();
			layer.msg(result.msg);
		}
	}, 'json');
}
</script>
<style>
html, body {
}

.layui-form-item {
	margin-bottom: 3px;
}
</style>
</head>
<body id="app">
	
	<div style="padding: 10px;">
		<form class="layui-form layui-form-pane">
			<div class="layui-form-item">
				<label class="layui-form-label">留言内容</label>
				<div class="layui-input-block">
					<input type="text"   autocomplete="off" id="content"
						value="" placeholder="请输入 留言内容" class="layui-input">
				</div>
			</div>
		</form>
		<div class="site-demo-button" style="margin-top: 20px;">
			<button id="save" onclick="save()"
				class="layui-btn site-demo-layedit" data-type="content">${btn_text }</button>
		</div>
	</div>


</body>

<script>
layui.use([ 'laydate', 'laypage', 'layer', 'table', 'carousel',
			'upload', 'element' ], function() {
		var laydate = layui.laydate //日期
		, laypage = layui.laypage //分页
		layer = layui.layer //弹层
		, table = layui.table //表格
		, carousel = layui.carousel //轮播
		, upload = layui.upload //上传
		,form = layui.form
		, element = layui.element; //元素操作
		
		
		
});
</script>
</html>
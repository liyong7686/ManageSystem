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

<!--添加  vue.js 支持加载-->
<script src="${pageContext.request.contextPath}/static/vue/vue.min.js"></script>
<!--添加  vue.js 支持加载-->

<script>
$(function(){
});

var save_url = '${save_url}';

function save() {
	//loading
	var index = layer.load(1, {
		shade : [ 0.1, '#fff' ]
		//0.1透明度的白色背景
	});
	var chubanDate = $("#chubanDate").val();
	$.post(save_url, {
		bianhao : app.bianhao,name : app.name,banhao : app.banhao,
		bianzhu:app.bianzhu,chubanshe:app.chubanshe,
		chubanDate:chubanDate,danjia:app.danjia,kucun:app.kucun
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
				<label class="layui-form-label">图书编号</label>
				<div class="layui-input-block">
					<input type="text"   autocomplete="off" v-model="bianhao"
						value="${book.bianhao }" placeholder="请输入 图书编号" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">书名</label>
				<div class="layui-input-block">
					<input type="text"   autocomplete="off" v-model="name"
						value="${book.name }" placeholder="请输入 书名" class="layui-input">
				</div>
			</div>
			
			
			<div class="layui-form-item">
				<label class="layui-form-label">出版书号</label>
				<div class="layui-input-block">
					<input type="text"   autocomplete="off" v-model="banhao"
						value="${book.banhao }" placeholder="请输入  出版书号" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">编著者</label>
				<div class="layui-input-block">
					<input type="text"   autocomplete="off" v-model="bianzhu"
						value="${book.bianzhu }" placeholder="请输入 编著者" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">出版社</label>
				<div class="layui-input-block">
					<input type="text"   autocomplete="off" v-model="chubanshe"
						value="${book.chubanshe }" placeholder="请输入 出版社" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">出版日期</label>
				<div class="layui-input-block">
					<input type="text" class="layui-input" value="<fmt:formatDate value="${book.chubanDate}" pattern="yyyy-MM-dd "/>" id="chubanDate" placeholder="yyyy-MM-dd">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">单价</label>
				<div class="layui-input-block">
					<input type="text"   autocomplete="off" v-model="danjia"
						value="${book.danjia }" placeholder="请输入 单价" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">库存数量 </label>
				<div class="layui-input-block">
					<input type="text"   autocomplete="off" v-model="kucun"
						value="${book.kucun }" placeholder="请输入 库存数量" class="layui-input">
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
var app = new Vue({
	el : '#app',
	data : {
	}
});
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
		,form = layui.form
		, element = layui.element; //元素操作
		
		
		 //常规用法
		  laydate.render({
		    elem: '#chubanDate'
		  });
		
});
</script>
</html>
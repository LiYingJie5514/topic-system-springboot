<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>我的购物车</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		h3 {
			clear: both;
			margin-left: 460px;
		}

		table {
			margin: 0px auto;
			width: 1024px;
		}

		table img {
			width: 100px;
			height: 100px;
			vertical-align: middle;
		}

		td {
			text-align: center;
		}

		th {
			line-height: 50px;
			background-color: #A52A2A;
			color: white;
		}

		#empty {
			margin: 0px 0px 0px 20%;
		}

		#submit {
			width: 100px;
			height: 40px;
			background-color: #A52A2A;
			border: 0px;
			color: white;
		}
		;
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$(".del").click(function() {
				return confirm("确定要删除吗？");
			});

		});
	</script>

</head>

<body>
<%@ include file="sysheader.jsp"%>
<h3>公告列表</h3>
<hr>
<form action="" method="post">
	<c:if test="${empty bulletins}">
		<div id="empty">
<%--			<a href="/" ><img src="img/che.jpg"></a>--%>
			暂无公告
		</div>
	</c:if>
	<c:if test="${!empty bulletins}">
		<table>
			<tr>
				<th>编号</th>
				<th>标题</th>
				<th>操作</th>
			</tr>

			<c:forEach items="${bulletins}" var="bulletin">
				<tr class="td">
					<td>${bulletin.id}</td>
					<td>${bulletin.title}</td>
					<td>
						<a href="/sys/toUpdate?id=${bulletin.id}">更改</a>
						<a href="/sys/deleteBul?id=${bulletin.id}" class="del">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</form>
<div style="height: 190px"></div>
<%@ include file="../footer.jsp" %>
</body>
</html>

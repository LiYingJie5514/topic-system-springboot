<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table{margin: 13% auto;width: 130px;}
/*html body{background-image: url("/img/logbg1.png");height:649px;width: 1349px;margin-left: 300px}*/

</style>


  </head>
  
  <body>
  <%@ include file="adminheader.jsp" %>
    <div>
    	<table>
    	<caption>网站后台管理平台</caption>
    		<tr><td>&nbsp;</td></tr>
    		<tr><td>&nbsp;</td></tr>
    		<tr><td><a href="adminUser/list">用户信息管理</a></td></tr>
    		<tr><td>&nbsp;</td></tr>
    		<tr><td><a href="adminGood/list">课程管理</a></td></tr>
    	</table>
    </div>
  </body>
</html>

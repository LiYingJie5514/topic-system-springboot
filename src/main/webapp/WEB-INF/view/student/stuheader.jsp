<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
  <link rel="stylesheet" href="../../../css/1.css" type="text/css"></link>
  
  <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
  
  <script type="text/javascript" src="../js/header.js"></script>
  </head>
  
  <body>
     <c:if test="${empty username}">
 	 <script type="text/javascript">
	$(document).ready(function () {
		$("#span4").hide();
	
	});
 </script>
 </c:if>
 <c:if test="${!empty username}">
 <script type="text/javascript">
	$(document).ready(function () {
		$("#span3").hide();
	});
	var error = '${error}';
	if(error != '')
		alert(error);
	
	var success = '${success}';
	if(success != ''){
        alert(success);
        window.location.href="/login";
    }

 </script>
  </c:if>
  <div style="width: 100%">
  
	<div id="top"  >
		<span id="span1" style="margin-left: 450px;" >
			<a href="common/queryBulletins">选课系统学生端</a>
		</span>
		<span id="span2" style="margin-right: 450px;">
			<span id="span3"><a href="/login">登录</a> | <a href="register">注册</a></span>
			<span id="span4">欢迎登录！${username}|<a href="userInfo/exit">退出</a></span>
		</span>
    </div>

  <div id="menu">
    <ul>
        <li><a href="/common/queryBulletins">首页</a></li>
        <li><a href="/student/getTopics">课题选择</a></li>
        <li><a href="/userInfo/userInfo">个人信息</a></li>
        <li><a href="/common/getHistoryTopics">历届课题</a></li>
    </ul>
  </div>
  </div>
  </body>
</html>

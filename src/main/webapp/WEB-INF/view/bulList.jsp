<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <title>公告列表</title>

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

        th {
            line-height: 50px;
            background-color: #A52A2A;
            color: white;
        }

        #empty {
            margin: 0px 0px 0px 20%;
        }
		;
    </style>
</head>

<body>
<c:if test="${usertype eq 0}">
    <%@ include file="student/stuheader.jsp" %>
</c:if>
<c:if test="${usertype eq 1}">
    <%@ include file="admin/adminheader.jsp" %>
</c:if>
<c:if test="${usertype eq 2}">
    <%@ include file="dep/depheader.jsp" %>
</c:if>
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
            <c:forEach items="${bulletins}" var="bulletin">
                <tr class="td">
                    <td>
                        <a href="/common/bulletinInfo?id=${bulletin.id}">
							${bulletin.title}
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</form>
<div style="height: 190px"></div>
<%@ include file="footer.jsp" %>
</body>
</html>

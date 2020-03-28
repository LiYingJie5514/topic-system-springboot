<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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

    <title>历届课题列表</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }

        td {
            border: 1px solid #808080;
            padding: 2px 0px;
        }

        table {
            border-collapse: collapse;
            margin: 0px auto;
            width: 80%;
        }

        table img {
            width: 100px;
            height: 100px;
        }

        #table1 td {
            border: 0px;
        }

        #header {
            background-color: red;
            color: white;
            font-weight: bold;
            text-align: center;
            line-height: 28px;
        }

        #header a {
            color: white;
            text-decoration: none;
        }

        .chb {
            text-align: center;
        }


        caption {
            font-size: 20px;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function checkall() {
            var checkboxes = document.getElementsByName("chb");
            for (var i = 0; i < checkboxes.length; i++) {
                checkboxes[i].checked = document.getElementById("all").checked;
            }
        }

        $(document).ready(function () {
            $(".del").click(function () {
                return confirm("确定要删除吗？");
            });
        });
    </script>
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
<div>
    <%--<form action="/dep/queryTopics" method="post">
        <table id="table1">
            <tr>
                <td>手机号:&nbsp;<input type="text" id="cellphone" name="cellphone"/>
                    课题状态:&nbsp;<select name="status" id="status" >
                        <option value="10" selected>全部</option>
                        <option value="0">待审核</option>
                        <option value="1">通过</option>
                        <option value="2">未通过</option>
                    </select>
                    &nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </form>--%>
    <br>
    <form action="adminGood/mdel" method="post">
        <table>
            <tr id="header">
                <td>课题编号</td>
                <td>题目</td>
                <td>教师手机号</td>
                <td>年级</td>
            </tr>
            <c:forEach var="topic" items="${topics}" begin="0"
                       end="${topics.size()}">
                <tr>
                    <td align="center">${topic.topicId}</td>
                    <td align="center">${topic.topicTitle}</td>
                    <td align="center">${topic.teacherName}</td>
                    <td align="center">${topic.topicPeriod}</td>
                </tr>
            </c:forEach>
        </table>
    </form>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>

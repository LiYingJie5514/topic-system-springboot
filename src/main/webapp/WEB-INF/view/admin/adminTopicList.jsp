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

    <title>课题列表</title>
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
            background-color: lightskyblue;
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
<%@ include file="adminheader.jsp" %>
<div>
    <%--<form action="adminUser/queryTopics" method="post">
        <table id="table1">
            <tr>
                <td>题目名称:<input type="text" id="topicTitle" name="topicTitle"/>&nbsp;&nbsp;<input
                        type="submit" value="查询">&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </form>--%>
    <br/>
    <form action="adminGood/mdel" method="post">
        <table>
            <tr id="header">
                <td>课题编号</td>
                <td>课题名称</td>
                <td>年级</td>
                <td>审核状态</td>
                <td>操作</td>
            </tr>
            <c:forEach var="topic" items="${topics}" begin="0"
                       end="${topics.size()}">
                <tr>

                    <td align="center">${topic.topicId}</td>
                    <td align="center">${topic.topicTitle}</td>
                    <td align="center">${topic.period}</td>
                    <td align="center">
                        <c:choose>
                            <c:when test="${topic.status eq 0}">
                                待审核
                            </c:when>
                            <c:when test="${topic.status eq 1}">
                                审核通过
                            </c:when>
                            <c:when test="${topic.status eq 2}">
                                审核不通过
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>

                    </td>
                    <td style="text-align: center;">
                        <a href="adminUser/toUpdate?id=${topic.topicId}">修改</a>
                        <br>
                        <br>
                        <a href="adminUser/delTopic?id=${topic.topicId}" class="del">删除</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </form>

</div>
<%@ include file="../footer.jsp" %>
</body>
</html>

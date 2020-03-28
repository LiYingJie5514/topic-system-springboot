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
<%@ include file="sysheader.jsp" %>
<div>
    <form action="sys/getUserList" method="post">
        <table id="table1">
            <tr>
                <td>手机号:&nbsp;<input type="text" id="cellphone" name="cellphone"/>
                    用户类型:&nbsp;<select name="userType" id="userType" >
                        <option value="10" selected>全部</option>
                        <option value="0">学 生</option>
                        <option value="1">教师</option>
                        <option value="2">系主任</option>
                        <option value="3">管理员</option>
                    </select>
                    &nbsp;&nbsp;<input type="submit" value="查询">&nbsp;&nbsp;
                </td>
            </tr>
        </table>
    </form>
    <br>
    <form action="adminGood/mdel" method="post">
        <table>
            <tr id="header">
                <td>用户名</td>
                <td>用户密码</td>
                <td>用户类型</td>
                <td>用户手机号</td>
                <td>操作</td>
            </tr>
            <c:forEach var="user" items="${userList}" begin="0"
                       end="${userList.size()}">
                <tr>
                    <%--<td class="chb"><input type="checkbox" name="chb"
                                           value="${goods.id}"></td>--%>

                    <td align="center">${user.userName}</td>
                    <td align="center">${user.passWord}</td>
                    <td align="center">
                        <c:choose>
                            <c:when test="${user.userType eq 0}">
                                学生
                            </c:when>
                            <c:when test="${user.userType eq 1}">
                                教师
                            </c:when>
                            <c:when test="${user.userType eq 2}">
                                系主任
                            </c:when>
                            <c:when test="${user.userType eq 3}">
                                管理员
                            </c:when>
                            <c:otherwise></c:otherwise>
                        </c:choose>
                    </td>
                    <td align="center">${user.cellphone}</td>
                    <td style="text-align: center;">
                        <a href="/userInfo/userInfo?type=1&phone=${user.cellphone}">修改</a>
                        <br>
                        <br>
                        <a href="/sys/deleteUser?cellphone=${user.cellphone}" class="del">删除</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </form>

</div>
<%@ include file="../footer.jsp" %>
</body>
</html>

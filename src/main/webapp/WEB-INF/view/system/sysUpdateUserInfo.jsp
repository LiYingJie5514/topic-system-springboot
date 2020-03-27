<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
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

    <title>修改用户信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script src="/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script type="text/javascript">

        $(function () {
            $("#isUpdate").click(
                function () {
                    if ($("#isUpdate").checked) {
						$("#newPassword").attr("disabled", "");
						$("#newPasswordAgain").attr("disabled", "");
                    } else {
                        $("#newPassword").attr("disabled", true);
                        $("#newPasswordAgain").attr("disabled", true);
                    }
                });
        });
    </script>

</head>

<body>

<%@ include file="sysheader.jsp" %>
<div style="margin-top: 80px;" align="center">
    <form action="/sys/updateUser" method="post">
        <table width="511px" cellspacing="4px" cellpadding="1px"
               style="margin-left: 260px;">

            <tr>
                <td width="103" height="80"
                    style="font-size: 13px; font-weight: bold; color: red">用户名
                </td>
                <td colspan="2"><input type="text"
                                       style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999"
                                       id="userName" name="userName" value="${user.userName }"/></td>
                <td width="112" id="v1">&nbsp;</td>
            </tr>

            <tr>
                <td width="103" height="80"
                    style="font-size: 13px; font-weight: bold; color: red">密码
                </td>
                <td colspan="2"><input type="text"
                                       style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999"
                                       id="passWord" name="passWord" value="${user.passWord }"/></td>
                <td width="112" id="v2">
                    &nbsp;
                </td>
            </tr>
            <tr>
                <td width="103" height="80"
                    style="font-size: 13px; font-weight: bold; color: red">手机号
                </td>
                <td colspan="2"><input type="text"
                                       style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999"
                                       id="cellphone" name="cellphone" value="${user.cellphone }" readonly="readonly"/></td>
                <td width="112" id="v3">&nbsp;</td>
            </tr>
            <tr>
                <td width="103" height="80"
                    style="font-size: 13px; font-weight: bold; color: red">用户类型
                </td>
                <td colspan="2">
                    <select name="userType" id="userType" style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999">
                        <option value="0" <c:if test="${user.userType eq 0}">selected</c:if>>学 生</option>
                        <option value="1" <c:if test="${user.userType eq 1}">selected</c:if>>教师</option>
                        <option value="2" <c:if test="${user.userType eq 2}">selected</c:if>>系主任</option>
                        <option value="3" <c:if test="${user.userType eq 3}">selected</c:if>>管理员</option>
                    </select>
                </td>
                <td width="112" id="v4">&nbsp;</td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="修改">
                    <input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

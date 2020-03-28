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

    <title>修改用户信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script src="/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script type="text/javascript">

        $(function () {

            $("#userName").blur(function() {
                if ($(this).val().length > 3 && $(this).val().length < 16) {
                    $("#v1").css("font-size", "13px").css("color", "#339933");
                    $("#v1").html("用户名格式正确！");
                } else {
                    $("#v1").css("font-size", "13px").css("color", "#F00");
                    $("#v1").html("格式错误限制4-15长度！");
                }
            });
            var reg = /^[0-9_a-zA-Z]{6,20}$/; //限制输入数字、字母、下划线，6-20长度，不能为空

            $("#newPassword").blur(function() {
                if (reg.test($(this).val())) {
                    $("#v4").css("font-size", "13px").css("color", "#339933");
                    $("#v4").html("密码格式正确！");
                } else {
                    $("#v4").css("font-size", "13px").css("color", "#F00");
                    $("#v4").html("密码不可用！限制数字、字母、下划线，6-20长度！");
                }
            });

            $("#newPasswordAgain").blur(function() {
                if ($("#newPassword").val() == $("#newPasswordAgain").val()) {
                    $("#v5").css("font-size", "13px").css("color", "#339933");
                    $("#v5").html("密码一致！");
                } else {
                    $("#v5").css("font-size", "13px").css("color", "#F00");
                    $("#v5").html("密码不一致！");
                }

            });

        });

        $(function() {
            $("#tijiao").click(
                function() {
                    $("form").submit();
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
<div style="margin-top: 20px;" align="center">
    <form action="userInfo/updateUserInfo" method="post">
        <table width="511px" cellspacing="4px" cellpadding="1px">

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
                    style="font-size: 13px; font-weight: bold; color: red">原始密码
                </td>
                <td colspan="2"><input type="password"
                                       style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999"
                                       id="passWord" name="passWord" value="${user.passWord }"/></td>
                <td width="112" id="v2">
<%--                    <input type="checkbox" id="isUpdate" name="isUpdate"/>修改密码--%>
                </td>
            </tr>

            <tr>
                <td width="103" height="80"
                    style="font-size: 13px; font-weight: bold; color: red">新密码
                </td>
                <td colspan="2"><input type="password"
                                       style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999"
                                       id="newPassword" name="newPassword"/></td>
                <td width="112" id="v4">&nbsp;</td>
            </tr>

            <tr>
                <td width="103" height="80"
                    style="font-size: 13px; font-weight: bold; color: red">再次确认
                </td>
                <td colspan="2"><input type="password"
                                       style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999"
                                       id="newPasswordAgain" name="newPasswordAgain"/></td>
                <td width="112" id="v5">&nbsp;</td>
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
                <td colspan="2" align="center">
<%--                    <input type="submit" value="修改">--%>
                    <img src="/img/add_topic.png" id="tijiao" style="margin-left: 30px" />
                </td>
            </tr>
        </table>
    </form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

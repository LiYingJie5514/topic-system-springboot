<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: 12941
  Date: 2020/3/22
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $("#tijiao").click(
                function() {
                    $("form").submit();
                });
        });
    </script>

</head>
<body>
    <%@ include file="sysheader.jsp" %>

    <c:if test="${empty username}">
        <script type="text/javascript">
            $(document).ready(function () {
                alert("请先登录");
                $(location).attr('href', '/login');
            });
        </script>
    </c:if>

    <div>
        <form action="/sys/updateBul" method="post">
            <table width="511px" cellspacing="4px" cellpadding="1px"
                   style="margin-left: 260px;">
                <input type="hidden" id="id" name="id" value="${bulletin.id}"/>
                <tr>
                    <td width="103" height="80"
                        style="font-size: 13px; font-weight: bold; color: red">标题</td>
                    <td colspan="2"><input type="text"
                                           style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999"
                                           id="title" name="title" value="${bulletin.title}"/></td>
                    <td width="112" id="v1">&nbsp;</td>
                </tr>
                <tr>
                    <td height="74"
                        style="font-size: 13px; font-weight: bold; color: red">内容</td>
                    <td colspan="2">
                    <textarea id="content" name="content" style="width: 250px; height: 350px;color: #999;">${bulletin.content}</textarea>
                    <td id="v2">&nbsp;</td>
                </tr>
                <tr>
                    <td height="55" colspan="4"><img src="/img/add_topic.png"
                                                     id="tijiao" style="margin-left: 30px" /></td>
                </tr>
                <tr>
                    <td height="49" colspan="4" id="v6">&nbsp;</td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>

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
    <style type="text/css">
        body{text-align:center}
        #divcss5{display: flex;justify-content: center;}
    </style>

</head>
<body>
    <%@ include file="adminheader.jsp" %>
    <div style="display: block; width: 100%; height: 20px"></div>
    <c:if test="${empty username}">
        <script type="text/javascript">
            $(document).ready(function () {
                alert("请先登录");
                $(location).attr('href', '/login');
            });
        </script>
    </c:if>

    <div  id="divcss5">
        <form action="adminUser/addTopic" method="post">
            <table >
                <input type="hidden" id="teacherId" name="teacherId"/>
                <tr>
                    <td width="103" height="80"
                        style="font-size: 13px; font-weight: bold; color: red">请输入标题</td>
                    <td colspan="2"><input type="text"
                                           style="display: block; width: 250px; height: 35px; font-size: 13px; color: #999"
                                           id="topicTitle" name="topicTitle" /></td>
                    <td width="112" id="v1">&nbsp;</td>
                </tr>
                <tr>
                    <td height="74"
                        style="font-size: 13px; font-weight: bold; color: red">请输入内容</td>
                    <td colspan="2">
                    <textarea id="topicContent" name="topicContent" style="width: 250px; height: 350px; font-size: 13px; color: #999;"></textarea>
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
    <%@ include file="../footer.jsp" %>
</body>
</html>

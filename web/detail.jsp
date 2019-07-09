<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/31
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
</head>

<body>
<div style="width:500px; margin:0px auto">
    <div style="width:500px; margin:0px auto; text-align:center">
        <h2>详细信息</h2></div>
    <div>
        <form  method="post">
            <table width="500" border="1">
                <tr>
                    <td width="144">景点介绍</td>
                    <td width="340">

                        <textarea name="introduce" id="introduce" cols="45" rows="5">${sessionScope.toursinfo.introduce}</textarea></td>
                </tr>
                <tr>
                    <td>发布时间</td>
                    <td><fmt:formatDate value="${sessionScope.toursinfo.pubtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                </tr>
                <tr>
                    <td>票价</td>
                    <td>${sessionScope.toursinfo.price}</td>
                </tr>
                <tr>
                    <td>城市</td>
                    <td>${sessionScope.toursinfo.city.cityname}</td>
                </tr>

                <tr>
                    <td colspan="2" align="center" valign="middle"><input type="button" name="btnReturn" id="btnReturn" value="返回" onclick="history.go(-1)" /></td>
                </tr>
            </table>
        </form>
    </div>

</div>
</body>
</html>

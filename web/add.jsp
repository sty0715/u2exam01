<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/31
  Time: 14:33
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
        <h2>添加信息</h2></div>
    <div>
        <form action="${pageContext.request.contextPath}/add.do" method="post">
            <table width="500" border="1">
                <tr>
                    <td width="144">景点介绍</td>
                    <td width="340"><label for="introduce"></label>

                        <textarea name="introduce" id="introduce" cols="45" rows="5"></textarea></td>
                </tr>
                <tr>
                    <td>发布时间</td>
                    <td><input type="text" name="pubtime" id="pubtime" /></td>
                </tr>
                <tr>
                    <td>票价</td>
                    <td><input type="text" name="price" id="price" /></td>
                </tr>
                <tr>
                    <td>城市</td>
                    <td><label for="cityid"></label>
                        <select name="cityid" id="cityid">
                            <option value="-1">请选择</option>
                            <c:if test="${sessionScope.cityList!=null}">
                                <c:forEach var="city" items="${sessionScope.cityList}">
                                    <option value="${city.cityid}">${city.cityname}</option>
                                </c:forEach>
                            </c:if>
                        </select>

                </tr>

                <tr>
                    <td colspan="2" align="center" valign="middle"><input type="submit" name="btnAdd" id="btnAdd" value="添加" /></td>
                </tr>
            </table>
        </form>
    </div>

</div>
</body>
</html>

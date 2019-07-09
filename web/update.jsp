<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/31
  Time: 15:09
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
        <h2>修改信息</h2></div>
    <div>
        <form action="${pageContext.request.contextPath}/update.do" method="post">
            <table width="500" border="1">
                <tr>
                    <td width="144">景点介绍</td>
                    <td width="340"><label for="introduce"></label>
                        <input type="hidden" name="id" id="id" value="${sessionScope.toursinfo.id}">
                        <textarea id="introduce" name="introduce" cols="45" rows="5">${sessionScope.toursinfo.introduce}</textarea>
                    </td>
                </tr>
                <tr>
                    <td>发布时间</td>
                    <td><input type="text" name="pubtime" id="pubtime" value='<fmt:formatDate value="${sessionScope.toursinfo.pubtime}" pattern="yyyy-MM-dd"></fmt:formatDate>'/></td>
                </tr>
                <tr>
                    <td>票价</td>
                    <td><input type="text" name="price" id="price" value="${sessionScope.toursinfo.price}"/></td>
                </tr>
                <tr>
                    <td>城市</td>
                    <td><label for="cityid"></label>
                        <select name="cityid" id="cityid">
                            <option value="-1">请选择</option>
                            <c:if test="${sessionScope.cityList!=null}">
                                <c:forEach var="city" items="${sessionScope.cityList}">
                                    <option value="${city.cityid}"
                                            <c:if test="${sessionScope.toursinfo.cityid==city.cityid}">selected="selected"</c:if>
                                    >${city.cityname}</option>
                                </c:forEach>
                            </c:if>
                        </select>

                </tr>

                <tr>
                    <td colspan="2" align="center" valign="middle"><input type="submit" name="btnAdd" id="btnAdd" value="修改" /></td>
                </tr>
            </table>
        </form>
    </div>

</div>
</body>
</html>
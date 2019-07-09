<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/5/31
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
</head>

<body style="width:900px; margin:0px auto;">
<div style="width:900px; text-align:center">
    <h2>旅游景点列表</h2>
</div>
<div style="width:880px; text-align:right; padding-right:20px;"><a href="${pageContext.request.contextPath}/per_add.do">添加信息</a></div>
<div style="width:900px; text-align:center">
    <form id="form"; action="${pageContext.request.contextPath}/list.do" method="post">
        城市名称：
        <select name="cityid" id="cityid">
            <option value="-1">请选择</option>
            <c:if test="${sessionScope.cityList!=null}">
                <c:forEach items="${sessionScope.cityList}" var="city">
                    <option value="${city.cityid}"
                            <c:if test="${sessionScope.searchParam.cityid==city.cityid}">selected="selected"</c:if>
                    >${city.cityname}</option>
                </c:forEach>
            </c:if>
        </select>


        价格：
        <input name="min_price" type="text" id="min_price" size="7" value="${sessionScope.searchParam.min_price}" />
        到
        <input name="max_price" type="text" id="max_price" size="7" value="${sessionScope.searchParam.max_price}" />
        <input name="pageNo" type="hidden" id="pageNo" value="1">
        <input type="submit" name="btnSearch" id="btnSearch" value="查询" />
    </form>
</div>
<div style="width:900px; text-align:center">
    <table width="900" border="1">
        <tr>
            <td>景点编号</td>
            <td>景点介绍</td>
            <td>发布时间</td>
            <td>价格</td>
            <td>城市名</td>
            <td>详细</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <c:if test="${sessionScope.page.list!=null}">
            <c:forEach items="${sessionScope.page.list}" var="tour">
                <tr>
                    <td>${tour.id}</td>
                    <td>${tour.introduce}</td>
                    <td><fmt:formatDate value="${tour.pubtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td>${tour.price}</td>
                    <td>${tour.city.cityname}</td>
                    <td><a href="${pageContext.request.contextPath}/detail.do?id=${tour.id}">详细</a></td>
                    <td><a href="${pageContext.request.contextPath}/per_update.do?id=${tour.id}">修改</a></td>
                    <td><a href="javascript:do_delete(${tour.id})">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>
        <tr>
            <td colspan="9" align="center"><a href="javascript:do_page(1)">首页</a>
                <a href="javascript:do_page(${sessionScope.page.pageNo-1})">上一页</a>
                <a href="javascript:do_page(${sessionScope.page.pageNo+1})">下一页</a>
                <a href="javascript:do_page(${sessionScope.page.totalPage})">末页</a>
                ${sessionScope.page.pageNo}/${sessionScope.page.totalPage}页
            </td>
        </tr>
    </table>

</div>

</body>
<script src="js/jquery-1.12.4.js"></script>
<script type="application/javascript">
    function do_delete(id) {
        if (confirm("是否删除")){
            location.href="${pageContext.request.contextPath}/delete.do?id="+id;
        }
    }
    function do_page(pno) {
        var form=document.getElementById("form");
       document.getElementById("pageNo").value=pno;
       form.submit();
    }
</script>
</html>

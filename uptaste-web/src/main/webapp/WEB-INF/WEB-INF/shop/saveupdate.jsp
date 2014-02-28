<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14-2-24
  Time: 上午10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:choose>
    <c:when test="${shop['new']}">
        <c:set var="method" value="post"/>
    </c:when>
    <c:otherwise>
        <c:set var="method" value="put"/>
    </c:otherwise>
</c:choose>

<h2>
    <c:if test="${shop['new']}">新建</c:if>
    店铺
</h2>

<form:form modelAttribute="shop" method="${method}">

    名称：<form:input path="name"></form:input><br>
    说明：<form:textarea path="shortDesc" ></form:textarea><br>
    可用？是<form:radiobutton path="status" value="1" checked="checked"></form:radiobutton>
    否<form:radiobutton path="status" value="0"></form:radiobutton>
    <div class="form-actions">
        <c:choose>
            <c:when test="${shop['new']}">
                <button type="submit">Add Shop</button>
            </c:when>
            <c:otherwise>
                <button type="submit">Update Shop</button>
            </c:otherwise>
        </c:choose>
    </div>
</form:form>
</body>
</html>

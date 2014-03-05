<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:choose>
    <c:when test="${category['new']}">
        <c:set var="method" value="post"/>
    </c:when>
    <c:otherwise>
        <c:set var="method" value="put"/>
    </c:otherwise>
</c:choose>

<h2>
    <c:if test="${category['new']}">新建</c:if>
    类别
</h2>

<form:form modelAttribute="category" method="${method}">

    名称：<form:input path="name"></form:input><br>
    说明：<form:textarea path="shortDesc" ></form:textarea><br>
    可用？是<form:radiobutton path="status" value="1" checked="checked"></form:radiobutton>
         否<form:radiobutton path="status" value="0"></form:radiobutton><br>

    <div class="form-actions">
        <c:choose>
            <c:when test="${category['new']}">
                <button type="submit">Add Category</button>
            </c:when>
            <c:otherwise>
                <button type="submit">Update Category</button>
            </c:otherwise>
        </c:choose>
    </div>
</form:form>
</body>
</html>

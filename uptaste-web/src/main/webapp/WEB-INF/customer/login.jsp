<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
${message}
<form:form method="post" modelAttribute="customer">
<table>
    <thead>用户登录</thead>
    <tbody>
        <tr><td>用户名：</td><td><form:input path="username"/></td></tr>
        <tr><td>密码：</td><td><form:input path="password"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="立即登录"></td></tr>
        <tr><td><a href="#" title="找回密码">忘记密码？</a></td><td><a href="/register" title="注册一个用户">我要注册！</a></td></tr>
    </tbody>
</table>
</form:form>
</body>
</html>

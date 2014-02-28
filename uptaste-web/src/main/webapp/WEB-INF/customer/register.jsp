<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form:form method="post" modelAttribute="customer">
    <table>
        <thead>用户注册</thead>
        <tbody>
        <tr><td>用户名：</td><td><form:input path="username"/></td></tr>
        <tr><td>密码：</td><td><form:input path="password"/></td></tr>
        <tr><td>确认密码：</td><td><input type="text"></td></tr>
        <tr><td colspan="2"><input type="submit" value="立即注册"></td></tr>
        <tr><td colspan="2"><a href="/login" title="返回登录">返回登录</a></td></tr>
        </tbody>
    </table>
</form:form>
</body>
</html>

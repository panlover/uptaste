<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yudeyang
  Date: 14-2-22
  Time: 下午10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" modelAttribute="merchant">
    <table>
        <thead>商户登录</thead>
        <tbody>
        <tr><td>用户名：</td><td><form:input path="username"/></td></tr>
        <tr><td>密码：</td><td><form:input path="password"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="立即登录"></td></tr>
        <tr><td><a href="#" title="找回密码">忘记密码？</a></td><td><a href="/merchant/register" title="注册一个用户">我要注册！</a></td></tr>
        </tbody>
    </table>
</form:form>
</body>
</html>

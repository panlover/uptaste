<%--
  Created by IntelliJ IDEA.
  User: yudeyang
  Date: 14-2-22
  Time: 下午5:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商户主页</title>
</head>
<body>
我现在已经拥有的店铺
<table>
    <tr><td>店铺名称</td><td>顾客评分</td><td>操作</td></tr>
    <tr><td>shop1</td><td>9.91</td><td>删除&nbsp;修改</td></tr>
    <tr><td>shop2</td><td>8.01</td><td>操作&nbsp;修改</td></tr>
</table>

<a href="/merchant/${merchant.username}/shop/create">添加商铺</a><br>
</body>
</html>

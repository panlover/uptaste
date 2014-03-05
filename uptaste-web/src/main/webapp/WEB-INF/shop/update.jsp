<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <!-- Bootstrap -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="/resources/plugins/html5shiv.min.js"></script>
    <script src="/resources/plugins/respond.min.js"></script>
    <![endif]-->
    <link href="/resources/plugins/bootstrap3/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/resources/plugins/bootstrap3/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link href="/resources/style/css/header.css" rel="stylesheet" type="text/css">
    <link href="/resources/style/css/footer.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <jsp:include page="../common/header.jsp"></jsp:include>
    <div class="center col-md-12">
        <div class="row">
            <div class="col-md-2">
                <jsp:include page="../common/leftmenu.jsp"></jsp:include>
            </div>
            <div class="col-md-10">

                <h2>更新店铺</h2>
                <form:form modelAttribute="shop" method="post" role="form">
                    <input type="hidden" name="_method" value="put">
                    <div class="form-group">
                        <form:label path="name">名称</form:label>
                        <form:input path="name" class="form-control"></form:input>
                    </div>
                    <div class="form-group">
                        <form:label path="shortDesc">说明</form:label>
                        <form:textarea path="shortDesc" cols="20" rows="5"></form:textarea>
                    </div>
                    <div class="form-group">
                        <form:label path="status">是否可用？</form:label>
                        是<form:radiobutton path="status" value="1" checked="checked" ></form:radiobutton>
                        否<form:radiobutton path="status" value="0"></form:radiobutton>
                    </div>
                    <button type="submit" class="btn btn-default">添加店铺</button>
                </form:form>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>

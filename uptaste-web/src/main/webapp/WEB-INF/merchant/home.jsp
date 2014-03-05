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
                <p class="lead">我现在已经拥有的店铺</p>
                <div class="panel panel-default">
                    <div class="panel-heading">店铺1的名字</div>
                    <div class="panel-body">
                        <table>
                            <tr>
                                <td>店铺名称</td>
                                <td>顾客评分</td>
                                <td>操作</td>
                            </tr>
                            <tr>
                                <td>shop1</td>
                                <td>9.91</td>
                                <td>删除&nbsp;修改</td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading">店铺2的名字</div>
                    <div class="panel-body">
                        <table>
                            <tr>
                                <td>店铺名称</td>
                                <td>顾客评分</td>
                                <td>操作</td>
                            </tr>
                            <tr>
                                <td>shop1</td>
                                <td>9.91</td>
                                <td>删除&nbsp;修改</td>
                            </tr>
                        </table>
                    </div>
                </div>



                <a class="btn btn-default btn-block" href="/merchant/${merchant.username}/shop/create" role="button">添加商铺</a><br>
            </div>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>类别列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- CSS -->
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col"></div>
        <div class="col"><h1>类别列表</h1></div>
        <div class="col"><a href="${pageContext.request.contextPath}/cate/add.jsp">添加类别</a></div>
    </div>
    <div class="row">
        <div class="col-12">
            <table class="table table-striped table-bordered table-dark">
                <thead>
                <tr>
                    <th scope="col">编号</th>
                    <th scope="col">类别</th>
                    <th scope="col">数量</th>
                    <th scope="col">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cates}" var="cate">
                    <tr>
                        <th scope="row">${cate.cateId}</th>
                        <td>${cate.cateName}</td>
                        <td>${cate.cateNumber}</td>
                        <td><a href="${pageContext.request.contextPath}/cate/edit?cateId=${cate.cateId}">修改</a> | <a href="javascript:void(0);" onclick="del(${cate.cateId})">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-7ymO4nGrkm372HoSbq1OY2DP4pEZnMiA+E0F3zPr+JQQtQ82gQ1HPY3QIVtztVua" crossorigin="anonymous"></script>
<script>
    function del(id) {
        if (confirm("你确定要删除么？")) {
            location.href="${pageContext.request.contextPath}/cate/del?cateId=" + id;
        }
    }
</script>
</body>
</html>
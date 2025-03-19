<%--
  Created by IntelliJ IDEA.
  User: 不见根号
  Date: 2025/1/19
  Time: 上午9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- CSS -->
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <!-- Content here -->
    <div class="row">
        <div class="col"></div>
        <div class="col"><h1>添加博客</h1></div>
        <div class="col"></div>
    </div>
    <div class="row">
        <div class="col-12">
            <form action="${pageContext.request.contextPath}/blog/addHandle" method="post" enctype="multipart/form-data">
                <div class="form-group row">
                    <label for="title" class="col-sm-2 col-form-label">标题</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="title" id="title">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="cate" class="col-sm-2 col-form-label">类别</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="cateId" id="cate">
                            <option value="0">--请选择类别--</option>
                            <c:forEach items="${cates}" var="cate">
                                <option value="${cate.cateId}">${cate.cateName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="intro" class="col-sm-2 col-form-label">简介</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="blogIntro" id="intro" rows="3"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="thumb" class="col-sm-2 col-form-label">封面</label>
                    <div class="col-sm-10">
                        <input type="file" class="form-control-file" name="thumb" id="thumb">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="content" class="col-sm-2 col-form-label">内容</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="blogContent" id="content" rows="3"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">添加</button>
                        <button type="reset" class="btn btn-secondary">取消</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

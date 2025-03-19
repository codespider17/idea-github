<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>博客列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- CSS -->
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col"></div>
        <div class="col"><h1>博客列表</h1></div>
        <div class="col"></div>
    </div>
    <div class="row">
        <div class="col-12">
            <form action="${pageContext.request.contextPath}/blog/list" method="post">
                <table class="table">
                    <tr>
                        <td>按类</td>
                        <td>
                            <select name="cateId">
                                <c:forEach items="${cates}" var="cate">
                                    <option value="${cate.cateId}">${cate.cateName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input type="text" name="title" placeholder="请输入标题"> </td>
                        <td><input type="submit" value="搜索"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <table class="table">
                <tbody>
                <c:forEach items="${blogs.items}" var="blog">
                    <tr>
                        <td width="200px" rowspan="3"><img src="${pageContext.request.contextPath}/${blog.blogThumb}" width="350" height="200"> </td>
                        <td>${blog.blogTitle}</td>
                    </tr>
                    <tr>
                        <td>${blog.blogIntro}</td>
                    </tr>
                    <tr>
                        <td>赞数: ${blog.blogPraise} 踩数: ${blog.blogTread}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
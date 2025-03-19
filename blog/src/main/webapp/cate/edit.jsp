<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改类别</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- CSS -->
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/4.6.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <!-- Content here -->
    <div class="row">
        <div class="col"></div>
        <div class="col"><h1>修改类别</h1></div>
        <div class="col"></div>
    </div>
    <div class="row">
        <div class="col-12">
            <form action="${pageContext.request.contextPath}/cate/editHandle" method="post">
                <input type="hidden" name="cateId" value="${category.cateId}">
                <div class="form-group row">
                    <label for="cateName" class="col-sm-2 col-form-label">名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="cateName" id="cateName" value="${category.cateName}">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="cateNumber" class="col-sm-2 col-form-label">数字</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" name="cateNumber" id="cateNumber" value="${category.cateNumber}">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10">
                        <button type="submit" class="btn btn-primary">修改</button>
                        <button type="reset" class="btn btn-secondary">取消</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
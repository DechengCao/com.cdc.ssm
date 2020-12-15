
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bookID" value="${qBook.bookID}">
        <div class="form-group">
            <label >书籍名称: </label>
            <input type="text" name="bookname" class="form-control" value="${qBook.bookname}" required>
        </div>
        <div class="form-group">
            <label >书籍数量: </label>
            <input type="text" name="bookcounts" class="form-control" value="${qBook.bookcounts}" required>
        </div>
        <div class="form-group">
            <label >书籍详情: </label>
            <input type="text" name="detail" class="form-control" value="${qBook.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改" >
        </div>
    </form>

</div>

</body>
</html>

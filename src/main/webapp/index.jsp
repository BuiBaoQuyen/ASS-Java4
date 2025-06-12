<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Trang Quản lý</title></head>
<body>
<h1>Quản lý Sản phẩm</h1>
<form action="/admin" method="post">
    Mã: <input type="text" name="ma"><br>
    Tên: <input type="text" name="ten"><br>
    <input type="hidden" name="action" value="add">
    <input type="submit" value="Thêm">
</form>
<p>${products}</p>
</body>
</html>
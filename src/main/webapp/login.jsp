<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Đăng nhập</title></head>
<body>
<h1>Đăng nhập</h1>
<form action="/login" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Đăng nhập">
</form>
<p style="color:red">${error}</p>
</body>
</html>
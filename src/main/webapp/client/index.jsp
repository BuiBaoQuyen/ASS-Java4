<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Trang Khách hàng</title></head>
<body>
<h1>Mua sắm</h1>
<form action="/client" method="post">
    Sản phẩm:
    <select name="productId">
        <c:forEach var="product" items="${products}">
            <option value="${product.id}">${product.ten}</option>
        </c:forEach>
    </select><br>
    Số lượng: <input type="text" name="quantity"><br>
    <input type="hidden" name="action" value="addToCart">
    <input type="submit" value="Thêm vào giỏ">
</form>

<h2>Thanh toán</h2>
<form action="/client" method="post">
    <input type="hidden" name="action" value="checkout">
    <input type="submit" value="Thanh toán">
</form>

<h2>Tra cứu hóa đơn</h2>
<form action="/client" method="post">
    Mã hóa đơn: <input type="text" name="maHoaDon"><br>
    <input type="hidden" name="action" value="track">
    <input type="submit" value="Tra cứu">
</form>

<h3>Kết quả:</h3>
<p>${message}</p>
</body>
</html>
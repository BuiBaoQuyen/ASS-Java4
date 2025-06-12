<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06/06/2025
  Time: 1:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>San Pham Chi Tiet</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma san pham</th>
        <th>Ten san pham</th>
        <th>Dong san pham</th>
        <th>Mau sac</th>
        <th>Nam san xuat</th>
        <th>Nam bao hanh</th>
        <th>Mo ta</th>
        <th>So luong ton</th>
        <th>Gia nhap</th>
        <th>Gia ban</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listChiTietSanPham}" var="ctsp">
        <tr>
            <td>${ctsp.id}</td>
            <td>${ctsp.sanPham.ma}</td>
            <td>${ctsp.sanPham.ten}</td>
            <td>${ctsp.dongSanPham.ten}</td>
            <td>${ctsp.mauSac.ten}</td>
            <td>${ctsp.namSanXuat.ten}</td>
            <td>${ctsp.namBaoHanh}</td>
            <td>${ctsp.moTa}</td>
            <td>${ctsp.soLuongTon}</td>
            <td>${ctsp.giaNhap}</td>
            <td>${ctsp.giaBan}</td>
            <td><button><a href="/chi-tiet/detaill?id=${ctsp.id}">Detail</a></button></td>
            <td><button><a href="/chi-tiet/view-update?id=${ctsp.id}">Update</a></button></td>
            <td><button><a href="/chi-tiet/delete?id=${ctsp.id}">Delete</a></button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

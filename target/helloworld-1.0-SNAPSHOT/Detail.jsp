<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09/06/2025
  Time: 1:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiet</title>
</head>
<body>
Id: ${listDetail.id}
<br>Ma san pham: ${listDetail.sanPham.ma}
<br>Ten san pham: ${listDetail.sanPham.ten}e
<br>Dong san pham: ${listDetail.dongSanPham.ten}
<br>Mau sac: ${listDetail.mauSac.ten}
<br>Nam san xuat: ${listDetail.namSanXuat.ten}
<br>Nam bao hanh: ${listDetail.namBaoHanh}
<br>So luong ton: ${listDetail.moTa}
<br>So luong ton: ${listDetail.soLuongTon}
<br>Gia nhpap: ${listDetail.giaNhap}
<br>Gia ban: ${listDetail.giaBan}
</body>
</html>

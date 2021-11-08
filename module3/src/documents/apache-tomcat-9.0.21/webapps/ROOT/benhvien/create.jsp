<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 2021-11-01
  Time: 07:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="/asset/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/asset/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<div class="container-fluid">
    <div class="row p-lg-3">
        <div class="col-lg-12">
            <h3 class="text-center">Thêm mới</h3>
            <form action="/benhan?action=create" method="post">
                <div class="form-group">
                    <label for="category">Tên bệnh nhân</label>
                    <select class="form-control" id="category" name="ma_benh_nhan" required>
                        <c:forEach var="benhNhan" items="${benhNhanList}">
                            <option value="${benhNhan.ma_benh_nhan}">${benhNhan.ten_benh_nhan}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="price1">Ngày nhập viện</label>
                    <input type="date" class="form-control" id="price1" name="ngay_nhap_vien" required>
                </div>
                <div class="form-group">
                    <label for="price2">Ngày ra viện</label>
                    <input type="date" class="form-control" id="price2" name="ngay_ra_vien" required>
                </div>
                <div class="form-group">
                    <label for="price3">Lý do</label>
                    <input type="text" class="form-control" id="price3" name="ly_do" required>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2026
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>

<p>Tìm thấy ${count} sinh viên</p>

<a href="?sortBy=name">Sort Name</a>
<a href="?sortBy=gpa">Sort GPA</a>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Mã SV</th>
        <th>Họ tên</th>
        <th>Khoa</th>
        <th>Năm</th>
        <th>GPA</th>
        <th>Trạng thái</th>
        <th></th>
    </tr>

    <c:forEach var="s" items="${students}" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td>${s.studentCode}</td>
            <td>${s.fullName}</td>
            <td>${s.faculty}</td>
            <td>${s.enrollmentYear}</td>
            <td>${s.gpa}</td>

            <td>
                <c:choose>
                    <c:when test="${s.status == 'Đang học'}">
                        <span style="color:green;">Đang học</span>
                    </c:when>
                    <c:when test="${s.status == 'Bảo lưu'}">
                        <span style="color:orange;">Bảo lưu</span>
                    </c:when>
                    <c:otherwise>
                        <span style="color:blue;">Tốt nghiệp</span>
                    </c:otherwise>
                </c:choose>
            </td>

            <td>
                <a href="detail?id=${s.id}">Xem</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

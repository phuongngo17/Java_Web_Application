<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/7/2026
  Time: 7:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Danh sách nhân viên</h2>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Phòng ban</th>
            <th>Lương</th>
            <th>Đánh giá</th>
        </tr>

        <c:forEach var="e" items="${employees}">
            <tr>
                <td>${e.id}</td>
                <td>${e.fullName}</td>
                <td>${e.department}</td>
                <td>${e.salary}</td>

                <td>
                    <c:choose>
                        <c:when test="${e.salary >= 10000}">
                            Mức lương cao
                        </c:when>
                        <c:otherwise>
                            Mức lương cơ bản
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>

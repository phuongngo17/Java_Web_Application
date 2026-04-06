<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2026
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>

<table border="1">
    <tr>
        <th>Tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>

    <!-- Loop bằng JSTL -->
    <c:forEach var="student" items="${students}">
        <tr>
            <!-- chống XSS -->
            <td><c:out value="${student.name}" /></td>
            <td><c:out value="${student.score}" /></td>

            <td>
                <c:choose>
                    <c:when test="${student.score >= 8}">
                        Giỏi
                    </c:when>
                    <c:when test="${student.score >= 5}">
                        Khá
                    </c:when>
                    <c:otherwise>
                        Yếu
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>

</table>


</body>
</html>

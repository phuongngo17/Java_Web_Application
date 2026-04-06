<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/6/2026
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Dashboard</h2>

    <p>Tổng SV: ${total}</p>
    <p>GPA TB: ${avgGpa}</p>

    <p>Thủ khoa: ${top.fullName} (${top.gpa})</p>

    <ul>
        <c:forEach var="entry" items="${stats}">
            <li>${entry.key}: ${entry.value}</li>
        </c:forEach>
    </ul>
</body>
</html>

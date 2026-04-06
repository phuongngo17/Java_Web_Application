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
    <h2>Chi tiết sinh viên</h2>

    <p>${student.fullName}</p>
    <p>${student.studentCode}</p>
    <p>${student.faculty}</p>
    <p>${student.gpa}</p>

    <a href="/students">Quay lại</a>
</body>
</html>

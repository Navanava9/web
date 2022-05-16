<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <title>result</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
<p>查询结果</p>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>gender</td>
        <td>province</td>
        <td>city</td>
    </tr>
    <c:forEach var="stu" items="${result}">
        <tr>
            <td>${stu.ID}</td>
            <td>${stu.name}</td>
            <td>${stu.gender}</td>
            <td>${stu.province}</td>
            <td>${stu.city}</td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
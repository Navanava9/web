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
    <!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->

</head>

<body>
<p>查询结果</p>
<table border="1">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>gender</td>
        <td>phone</td>
        <td>email</td>
    </tr>
    <c:forEach var="stu" items="${result}">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.name}</td>
            <td>${stu.gender}</td>
            <td>${stu.phone_number}</td>
            <td>${stu.e_mail}</td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
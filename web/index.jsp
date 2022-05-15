<%--
  Created by IntelliJ IDEA.
  User: 40741
  Date: 2022/4/4
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <style>
        a {
            color: rgb(255, 255, 255);
            text-decoration: none;
        }

        * {
            margin: 0;
            padding: 0;
        }

        .container {
            height: 100%;
            background: linear-gradient(to left, rgba(193, 159, 241, 0.5), rgba(255, 128, 243, 0.5));
        }

        .select-box {
            text-align: center;
            top: 50%;
            left: 50%;
            border-radius: 20px;
            background-color: #fff;
            width: 250px;
            height: 320px;
            padding: 0px 50px;
            position: relative;
            transform: translate(-50%, -50%);
        }

        .select-part {
            position: relative;
            box-sizing: content-box;
            top: 20%;
            margin-bottom: 27px;
            padding: 5px 100px;
            border-radius: 10px;
            background: linear-gradient(to left, rgba(193, 159, 241, 0.5), rgba(255, 128, 243, 0.5));
        }
    </style>
</head>
<body>
<div class="container">
    <div class="select-box">
        <p class="select-part"><a title="登录" href="./html/login.html">登录</a></p>
        <p class="select-part"><a title="查询" href="./html/query.html">查询</a></p>
        <p class="select-part"><a title="注册" href="./html/register.html">注册</a></p>
        <p class="select-part"><a title="概要" href="./html/summary.html">概要</a></p>
    </div>
</div>

</body>
</html>

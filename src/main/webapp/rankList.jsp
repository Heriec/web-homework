<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>猜数</title>
</head>
<body>
<h1>猜数成绩排行榜</h1>
<table>
    <tr>
        <th>排名</th>
        <th>姓名</th>
        <th>猜对最少次数</th>
    </tr>

    <c:forEach var="user" items="${rank}">
        <tr>
            <td>${rank.indexOf(user) + 1}</td>
            <td>${user.getUser()}</td>
            <td>${user.getCount()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
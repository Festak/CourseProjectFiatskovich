<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 21.02.2017
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../../views/templates/navbar.jsp"/>
<br>

<table>
    <tr>
        <td>Категория</td>
        <td>Ваше действие</td>
    </tr>
        <c:forEach var="categories" items="${categories}">
    <tr>
        <td>${categories.name}</td>
        <td><a href="/user/subscribe/${categories.id}">Подписаться</a></td>
    </tr>
    </c:forEach>
<c:forEach var="subscribed" items="${subscribed}">
    <tr>
    <td>${subscribed.name}</td>
    <td><a href="/user/unsubscribe/${subscribed.id}">Отписаться</a></td>
    </c:forEach>
    </tr>
</table>


<jsp:include page="../../views/templates/scripts.jsp"/>
</body>
</html>

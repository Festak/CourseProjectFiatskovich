<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../../views/templates/navbar.jsp"/>
<br>
All reports:<br>
<table>
    <tr>
        <td>UserName</td>
        <td>UserEmail</td>
        <td>UserPhone</td>
        <td>Price</td>
        <td>Buy Date</td>
    </tr>
<c:forEach var="reports" items="${reports}">
    <tr>
        <td>${reports.userName}</td>
        <td>${reports.userEmail}</td>
        <td>${reports.userPhone}</td>
        <td>${reports.price}</td>
        <td>${reports.buyDate}</td>
    </tr>
</c:forEach>
</table>
<jsp:include page="../../views/templates/scripts.jsp"/>
</body>
</html>

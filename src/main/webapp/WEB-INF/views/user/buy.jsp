<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 22.02.2017
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Введите данные о себе, и мы в течение часа свяжемся с вами:
<jsp:include page="../../views/templates/navbar.jsp"/>
<br>
<form:form action="/user/buyall" modelAttribute="report">
    <form:hidden path="id"/><br>
    <form:input path="userName"/><br>
    <form:input path="userEmail"/><br>
    <form:input path="userPhone"/><br>
    <input type="submit" value="Купить"/>
</form:form>
<jsp:include page="../../views/templates/scripts.jsp"/>
</body>
</html>

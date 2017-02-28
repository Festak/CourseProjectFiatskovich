<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница покупки</title>
    <jsp:include page="../../views/templates/scripts.jsp"/>
</head>
<body>
<jsp:include page="../../views/templates/header.jsp"/>
<br>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
Введите данные о себе, и мы в течение часа свяжемся с вами:
<form:form action="/user/buyall" modelAttribute="report">
    <form:hidden path="id"/><br>
    <form:input path="userName"/><br>
    <form:input path="userEmail"/><br>
    <form:input path="userPhone"/><br>
    <input type="submit" value="Купить"/>
</form:form>
<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>

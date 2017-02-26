<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <title>EditProduct</title>
</head>
<body>
<jsp:include page="../../views/templates/navbar.jsp"/>

<form:form method="post" action="/admin/editproduct" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    <form:input path="name" value="${product.name}"/><br>
    <form:input path="weight" value="${product.weight}"/><br>
    <form:input path="temperature" value="${product.temperature}"/><br>
    <form:input path="memory" value="${product.memory}"/><br>
    <form:input path="price" value="${product.price}"/><br>
    <form:input path="imageUrl" value="${product.imageUrl}"/><br>
    <input type="submit" value="Изменить" />
</form:form>

<jsp:include page="../../views/templates/scripts.jsp"/>

</body>
</html>

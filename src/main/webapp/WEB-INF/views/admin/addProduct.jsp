<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 21.02.2017
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>Add product</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></head>
</head>
<body>
<jsp:include page="../../views/templates/navbar.jsp"/>
<br>

<form:form method="post" action="/admin/saveProduct" modelAttribute="productForm">
    <form:input path="name"/><br>
    <form:input path="weight"/><br>
    <form:input path="temperature"/><br>
    <form:input path="memory"/><br>
    <form:input path="price"/><br>
    <form:input path="imageUrl"/><br>
    <form:input path="advantageViewModel.description"/><br>
    <form:input path="categoryViewModel.name"/><br>

    <br/>
    <input type="submit" value="Сохранить!" />
</form:form>


<jsp:include page="../../views/templates/scripts.jsp"/>
</body>
</html>

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
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<jsp:include page="../../views/templates/scripts.jsp"/>
<script>
    $(function () {
        $("#slider").responsiveSlides({
            auto: true,
            speed: 500,
            namespace: "callbacks",
            pager: true,
        });
    });
</script>
</head>
<body>
<jsp:include page="../../views/templates/header.jsp"/>
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

<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>

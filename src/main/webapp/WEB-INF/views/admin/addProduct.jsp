<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 21.02.2017
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Добавить продукт</title>
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

<div class="content">
    <div class="contact">
        <div class="container">
            <h3>Добавьте продукт</h3>
            <div class="contact-grids">
                <div class="contact-form">
                    <form:form method="post" action="/admin/saveProduct" modelAttribute="productForm">
                        <form:hidden path="id"/>
                        <div class="contact-bottom" style="font-color: BLACK;">
                            <spring:bind path="name">
                            <div class="col-md-12 in-contact">
                                <span>Название продукта</span>
                                <form:input path="name"/><br>
                                    <form:errors path="name"/>
                            </div>
                            </spring:bind>
                            <spring:bind path="weight">
                            <div class="col-md-12 in-contact">
                                <span>Вес продукта</span>
                                <form:input path="weight"/></br>
                                    <form:errors path="weight"/>
                            </div>
                            </spring:bind>
                            <spring:bind path="temperature">
                            <div class="col-md-12 in-contact">
                                <span>Температура</span>
                                <form:input path="temperature"/></br>
                                <form:errors path="temperature"/>
                            </div>
                            </spring:bind>
                            <spring:bind path="memory">
                            <div class="col-md-12 in-contact form-group ${status.error ? 'has-error' : ''}">
                                <span>Память</span>
                                <form:input path="memory"/>
                                <form:errors path="memory"/>
                            </div>
                            </spring:bind>
                            <spring:bind path="price">
                            <div class="col-md-12 in-contact form-group ${status.error ? 'has-error' : ''}">
                                <span>Цена продукта</span>
                                <form:input path="price"/>
                                <form:errors path="price"/>
                            </div>
                            </spring:bind>
                            <spring:bind path="categoryViewModel.name">
                            <div class="col-md-12 in-contact form-group ${status.error ? 'has-error' : ''}">
                                <span>Категория продукта</span>
                                <form:input path="categoryViewModel.name"/>
                                <form:errors path="categoryViewModel.name"/>
                            </div>
                            </spring:bind>
                            <spring:bind path="advantageViewModel.description">
                            <div class="col-md-12 in-contact form-group ${status.error ? 'has-error' : ''}">
                                <span>Достоинство</span>
                                <form:input path="advantageViewModel.description"/><br>
                                <form:errors path="advantageViewModel.description"/>
                            </div>
                            </spring:bind>
                            <spring:bind path="imageUrl">
                            <div class="col-md-12 in-contact form-group ${status.error ? 'has-error' : ''}">
                                <span>Изображение</span>
                                <form:input path="imageUrl"/>
                                <form:errors path="imageUrl"/>
                                </spring:bind>
                                <input type="submit" value="Подтвердить"/>
                            </div>

                            <div class="clearfix"> </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>

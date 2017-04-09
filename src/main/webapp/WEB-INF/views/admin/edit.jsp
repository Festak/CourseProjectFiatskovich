<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <title>Редактировать продукт</title>
    <jsp:include page="../../views/templates/scripts.jsp"/>
</head>
<body>
<jsp:include page="../../views/templates/header.jsp"/>
<div class="content">
    <div class="contact">
        <div class="container">
            <h3>Редактирование товара</h3>
            <div class="contact-grids">
                <div class="contact-form">
                    <form:form method="post" action="/admin/editproduct" modelAttribute="product">
                        <form:hidden path="id" value="${product.id}"/>
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

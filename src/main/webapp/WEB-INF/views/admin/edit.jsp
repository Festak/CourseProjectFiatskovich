<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <h3>Оформите заказ</h3>
            <div class="contact-grids">
                <div class="contact-form">
                    <form:form method="post" action="/admin/editproduct" modelAttribute="product">
                        <form:hidden path="id" value="${product.id}"/>
                        <div class="contact-bottom">
                            <div class="col-md-6 in-contact">
                                <span>Название продукта</span>
                                <form:input path="name" value="${product.name}"/><br>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Вес продукта</span>
                                <form:input path="weight" value="${product.weight}"/>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Температура</span>
                                <form:input path="temperature" value="${product.temperature}"/>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Память</span>
                                <form:input path="memory" value="${product.memory"/>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Цена продукта</span>
                                <form:input path="price" value="${product.price}"/>
                            </div>
                            <div class="col-md-12 in-contact">
                                <span>Изображение</span>
                                <form:input path="imageUrl"/>
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

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
            <h3>Оформите заказ</h3>
            <div class="contact-grids">
                <div class="contact-form">
                    <form:form method="post" action="/admin/saveProduct" modelAttribute="productForm">
                        <form:hidden path="id"/>
                        <div class="contact-bottom">
                            <div class="col-md-6 in-contact">
                                <span>Название продукта</span>
                                <form:input path="name"/><br>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Вес продукта</span>
                                <form:input path="weight"/>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Температура</span>
                                <form:input path="temperature"/>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Память</span>
                                <form:input path="memory"/>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Цена продукта</span>
                                <form:input path="price"/>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Категория продукта</span>
                                <form:input path="categoryViewModel.name"/>
                            </div>
                            <div class="col-md-12 in-contact">
                                <span>Достоинство</span>
                                <form:input path="advantageViewModel.description"/><br>
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

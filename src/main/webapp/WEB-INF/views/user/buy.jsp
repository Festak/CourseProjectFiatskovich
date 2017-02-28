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
<div class="content">
    <div class="contact">
        <div class="container">
            <h3>Оформите заказ</h3>
            <div class="contact-grids">
                <div class="contact-form">
<form:form action="/user/buyall" modelAttribute="report">
    <form:hidden path="id"/>
                        <div class="contact-bottom">
                            <div class="col-md-6 in-contact">
                                <span>Ваше имя</span>
                                <form:input path="userName"/>
                            </div>
                            <div class="col-md-6 in-contact">
                                <span>Электронная почта</span>
                                <form:input path="userEmail"/>
                            </div>
                            <div class="col-md-12 in-contact">
                                <span>Телефон</span>
                                <form:input path="userPhone"/>
                                <input class="simpleCart_empty" type="submit" value="Подтвердить"/>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </form:form>
                </div>
                <div class="address">
                    <div class=" address-more">
                        <h2>Адрес</h2>
                        <div class="col-md-4 address-grid">
                            <i class="glyphicon glyphicon-map-marker"></i>
                            <div class="address1">
                                <p>Приходите сюда</p>
                                <p>ул. Городецкая 32</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="col-md-4 address-grid ">
                            <i class="glyphicon glyphicon-phone"></i>
                            <div class="address1">
                                <p>+37529 110-11-10</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="col-md-4 address-grid ">
                            <i class="glyphicon glyphicon-envelope"></i>
                            <div class="address1">
                                <p><a href="mailto:fiatskovich.w@gmail.com">@gmail.com</a></p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>

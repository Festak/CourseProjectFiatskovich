<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="col-sm-4 logo animated wow fadeInLeft" data-wow-delay=".5s">
                <h1><a href="/index">Магазин <span>электротехники</span></a></h1>
            </div>
            <div class="col-sm-4 world animated wow fadeInRight" data-wow-delay=".5s">
                <div class="cart box_1">
                    <a href="/product/basket">
                        <h3> <div class="total">
                            <span class="simpleCart_total"></span></div>
                            <img src="${contextPath}/resources/images/cart.png" alt=""/></h3>
                    </a>
                    <p><a href="/product/removeAllFromBasket" id="simpleCart_empty" class="simpleCart_empty">Очистить</a></p>



                </div>
            </div>
            <div class="col-sm-2 number animated wow fadeInRight" data-wow-delay=".5s">
                <span><i class="glyphicon glyphicon-phone"></i>110 11 10</span>
                <p>Консультант</p>
            </div>
            <div class="col-sm-2 search animated wow fadeInRight" data-wow-delay=".5s">
                <form:form style="float: right"
                           method="get" action="/indexsearch" commandName="form">
                    <form:input path="name" name="query" class="form-control col-md-4" placeholder="Поиск товара"/>
                </form:form>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="container">
        <div class="head-top">
            <div class="n-avigation">

                <nav class="navbar nav_bottom" role="navigation">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header nav_2">
                        <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#"></a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">

                        <ul class="nav navbar-nav nav_1">
                            <li><a href="/index">Главная</a></li>
                            <li><a href="/product/index">Товары</a></li>
                            <c:if test="${pageContext.request.userPrincipal.name == null}">
                                <li><a href="/login">Войти</a></li>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <form id="logoutForm" class="hidden" method="post" action="${contextPath}/logout">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                                <li><a href="/roleconditions">Личный кабинет</a></li>
                                <li><a onclick="document.forms['logoutForm'].submit()">Выйти</a></li>
                            </c:if>
                        </ul>
                    </div>
                </nav>
            </div>

                </div>

            <!---->
        </div>
    </div>
</div>
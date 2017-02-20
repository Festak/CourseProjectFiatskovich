<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">
                Магазин электротехники
            </a>
        </div>
        <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a href="/login">Войти</a></li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" class="hidden" method="post" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <li><a class="navbar-default" href="#">Личный кабинет</a></li>
                    <li><a class="navbar-default" onclick="document.forms['logoutForm'].submit()">Выйти</a></li>
                </c:if>
            </ul>
            <form class="navbar-form"  style="float: right">
            <input type="text" name="query" class="form-control col-lg-8" placeholder="Find">
            </form>
        </div>
    </div>
</nav>

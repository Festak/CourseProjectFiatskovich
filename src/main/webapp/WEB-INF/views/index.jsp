<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body ng-app="main">
<jsp:include page="templates/navbar.jsp"/>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <c:forEach var="categories" items="${categories}">
                <a href="/index/${categories.id}">${categories.name}</a><br>
            </c:forEach>
        </div>
        <div class="col-md-10">
            <div class="row">
                <c:forEach var="products" items="${products}">
                <div class="col-md-6">
            Name: ${products.name}<br>
                    <img src="${products.imageUrl}" style="width: 50px; height: 50px;"/>
            Advantages:<br>
            <c:forEach var="advantage" items="${products.advantages}">
                advantage: ${advantage.description}<br>
            </c:forEach>
                </div>
                    </c:forEach>

        </div>
        </div>
    </div>

</div>



<jsp:include page="templates/scripts.jsp"/>

</body>
</html>

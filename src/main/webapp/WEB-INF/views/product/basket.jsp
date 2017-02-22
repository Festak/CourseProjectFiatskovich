<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../../views/templates/navbar.jsp"/>
<a href="${contextPath}/user/buy">Купить все</a>
<c:forEach var="products" items="${products}">
    <div class="col-md-6">
        Name: ${products.name}<br>
        <img src="${products.imageUrl}" style="width: 50px; height: 50px;"/>
        Advantages:<br>
        <c:forEach var="advantage" items="${products.advantages}">
            advantage: ${advantage.description}<br>
        </c:forEach>
        <a href="/product/details/${products.id}">Details</a>
        <a href="/product/addtobasket/${products.id}">Add to basket</a>
        <a href="/product/removefrombasket/${products.id}">Remove</a>
    </div>
</c:forEach>

<jsp:include page="../../views/templates/scripts.jsp"/>
</body>
</html>

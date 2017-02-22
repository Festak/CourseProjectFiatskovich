<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 21.02.2017
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="../../views/templates/navbar.jsp"/>
<br>
<a href="/admin/report">Reports</a>
<br>
<a href="${contextPath}/admin/addProduct">Добавить продукт</a>
<div class="container">
    <div class="row">
        <div class="col-md-9">
            <div class="row">
                <c:forEach var="products" items="${products}">
                    <div class="col-md-4">
                        Name: ${products.name}<br>
                        <img src="${products.imageUrl}" style="width: 50px; height: 50px;"/>
                        <a href="/product/details/${products.id}">Details</a>
                        <a href="/admin/deleteProduct/${products.id}">Delete</a>
                        <a href="/admin/edit/${products.id}">Edit</a>
                    </div>
                    <br>

                </c:forEach>
            </div>
        </div>
<c:forEach var="users" items="${users}">
        <div class="col-md-3">
                    Name: ${users.username}<br>
                    Roles:<br>
                    <c:forEach var="role" items="${users.roles}">
                        ${role.name}<br>
                    </c:forEach>
                    Medals:<br>
                    <c:forEach var="medal" items="${users.medals}">
                        ${medal.name}<br>
                        <img src="${medal.imageUrl}" style="width: 16px; height: 16px;"/><br>
                    </c:forEach>
                <br>

        </div>
</c:forEach>
    </div>
</div>



<jsp:include page="../../views/templates/scripts.jsp"/>

</body>
</html>

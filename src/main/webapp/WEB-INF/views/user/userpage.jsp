<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница пользователя</title>
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
<br>

<table>
    <tr>
        <td>Категория</td>
        <td>Ваше действие</td>
    </tr>
        <c:forEach var="categories" items="${categories}">
    <tr>
        <td>${categories.name}</td>
        <td><a href="/user/subscribe/${categories.id}">Подписаться</a></td>
    </tr>
    </c:forEach>
<c:forEach var="subscribed" items="${subscribed}">
    <tr>
    <td>${subscribed.name}</td>
    <td><a href="/user/unsubscribe/${subscribed.id}">Отписаться</a></td>
    </c:forEach>
    </tr>
</table>

<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>

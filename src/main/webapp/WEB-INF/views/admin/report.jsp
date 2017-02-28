<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>Отчетность</title>
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
All reports:<br>
<table>
    <tr>
        <td>UserName</td>
        <td>UserEmail</td>
        <td>UserPhone</td>
        <td>Price</td>
        <td>Buy Date</td>
    </tr>
<c:forEach var="reports" items="${reports}">
    <tr>
        <td>${reports.userName}</td>
        <td>${reports.userEmail}</td>
        <td>${reports.userPhone}</td>
        <td>${reports.price}</td>
        <td>${reports.buyDate}</td>
    </tr>
</c:forEach>
</table>
<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>

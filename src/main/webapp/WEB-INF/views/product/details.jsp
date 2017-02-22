<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../../views/templates/navbar.jsp"/>

Name: ${product.name}<br>
<img src="${product.imageUrl}" style="width: 50px; height: 50px;"/>
Advantages:<br>
<c:forEach var="advantage" items="${product.advantages}">
    advantage: ${advantage.description}<br>
</c:forEach>


<jsp:include page="../../views/templates/scripts.jsp"/>
</body>
</html>

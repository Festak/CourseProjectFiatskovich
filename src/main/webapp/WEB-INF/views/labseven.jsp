<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 19.02.2017
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
<form method="POST" action="${contextPath}/labsevengo" class="form-signin">
    <h2 class="form-heading">Введите id интересующего ваш пользователя</h2>
        <input name="userid" type="text" class="form-control" placeholder="userId"
               autofocus="true"/>
       <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">К заданию</button>
</form><br>
</div>
</body>
</html>

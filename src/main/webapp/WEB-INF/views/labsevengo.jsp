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
Вам необходима информация об пользователе с номером: ${user.id}<br>
Его логин: ${user.username}<br>
Его адрес: ${user.secondAdres}<br>
Его кредит: ${user.credit}<br>
<a href="${contextPath}/labseven">Вернуться назад</a>
    </div>
</body>
</html>

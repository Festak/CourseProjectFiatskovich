<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Корзина</title>
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
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../../views/templates/header.jsp"/>
<div class="banner">
    <div class="matter-banner">
        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li>
                        <img src="${contextPath}/resources/images/mnogoHolodilnikov.jpg" alt="">
                        <div class="tes animated wow fadeInUp animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
                            <h2>Холодильники</h2>
                            <h3>В любом коилчестве</h3>
                            <h4>Иногда скидки</h4>
                            <p>Лучший вариант!</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="clearfix"> </div>
</div>
<div class="content">
<div class="container">
    <div class="check-out">
        <h2>Корзина товаров</h2>
        <table >
            <tr>
                <th>Товар</th>
                <th>Цена</th>
                <th>Подробности</th>
                <th>Удалить товар</th>
            </tr>
            <c:forEach var="products" items="${products}">
            <tr>
                <td class="ring-in"><a href="/product/details/${products.id}" class="at-in">
                    <img src="${products.imageUrl}" class="img-responsive" alt=""></a>
                    <div class="sed">
                        <h5>${products.name}</h5>
                        <p><c:forEach var="advantages" items="${products.advantages}">
                            ${advantages.description};
                        </c:forEach></p>
                    </div>
                    <div class="clearfix"> </div></td>
                <td>$${products.price}</td>
                <td>Вес: ${products.weight}</td>
                <td><a href="/product/removefrombasket/${products.id}">Удалить</a></td>
            </tr>
            </c:forEach>
        </table>

        <a href="/user/buy" class="to-buy">К покупке</a>
        <div class="clearfix"> </div>
    </div>
</div>
</div>
<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>

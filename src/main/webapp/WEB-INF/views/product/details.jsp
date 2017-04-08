<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>О товаре</title>
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
<div class="content">
<div class="single">
    <div class="container">
        <div class="col-md-9">
            <div class="col-md-5 grid">
                                <img src="${product.imageUrl}" style="width: 250px; height: 360px;"class="img-responsive">
            </div>
            <div class="col-md-7 single-top-in">
                <div class="single-para simpleCart_shelfItem">
                    <h2>Достоинства</h2>
                    <p><c:forEach var="advantages" items="${product.advantages}">${advantages.description};<br> </c:forEach></p>
                    <p>Вес: ${product.weight}</p>
                    <p>Память: ${product.memory}</p>
                    <p>Температура: ${product.temperature}</p>
                    <div class="star-on">
                        <ul>
                            <li><a href="/product/setonerating/${product.id}"><i class="glyphicon glyphicon-star"> </i></a></li>
                            <li><a href="/product/settworating/${product.id}"><i class="glyphicon glyphicon-star"> </i></a></li>
                            <li><a href="/product/setthreerating/${product.id}"><i class="glyphicon glyphicon-star"> </i></a></li>
                            <li><a href="/product/setfourrating/${product.id}"><i class="glyphicon glyphicon-star"> </i></a></li>
                            <li><a href="/product/setfiverating/${product.id}"><i class="glyphicon glyphicon-star"> </i></a></li>
                        </ul>
                        Рейтинг: ${product.rating}
                        <div class="clearfix"> </div>
                    </div>
                    <label class="add-to item_price">$${product.price}</label>
                    <a href="/product/addtobasket/${product.id}" class="cart item_add">В корзину</a>
                </div>
            </div>
            <div class="clearfix"> </div>
            <div class="content-top1">


                <c:forEach var="products" items="${products}">
                    <div class="col-md-4 col-md4">
                        <div class="col-md1 simpleCart_shelfItem">
                            <a href="/product/details/${products.id}">
                                <img class="img-responsive" src="${products.imageUrl}" style="width: 176px; height: 255px" alt="" />
                            </a>
                            <h3><a href="/product/details/${products.id}">${products.name}</a></h3>
                            <div class="price">
                                <h5 class="item_price">$${products.price}</h5>
                                <a href="/product/addtobasket/${products.id}" class="item_add">Add To Cart</a>
                                <div class="clearfix"> </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <div class="clearfix"> </div>
            </div>
        </div>
        <!----->
        <div class="col-md-3 product-bottom">
            <!--categories-->
            <div class=" rsidebar span_1_of_left">
                <h3 class="cate">Категории</h3>
                <ul class="menu-drop">
                    <c:forEach var="categories" items="${categories}">
                        <a href="/product/index/${categories.id}">${categories.name}</a><br>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
</div>


<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>

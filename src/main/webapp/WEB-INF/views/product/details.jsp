<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>О товаре</title>
    <jsp:include page="../../views/templates/scripts.jsp"/>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
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
                    <div class="star-on">
                        <ul>
                            <li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
                        </ul>
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

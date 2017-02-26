<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список товаров</title>
    <jsp:include page="../../views/templates/scripts.jsp"/>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<jsp:include page="../../views/templates/header.jsp"/>
<hr>
<div class="content">

<!--content-->
<div class="products">
    <div class="container">
        <h2>Products</h2>
        <div class="col-md-9">
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

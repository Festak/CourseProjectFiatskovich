<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Список товаров</title>
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
<!--content-->
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<div class="content">
    <div class="products">
        <div class="container">
            <h2>Товары</h2>
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
                                    <a href="/product/addtobasket/${products.id}" class="item_add">В корзину</a>
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
<!--//content-->
<jsp:include page="../../views/templates/footer.jsp"/>
</body>
</html>
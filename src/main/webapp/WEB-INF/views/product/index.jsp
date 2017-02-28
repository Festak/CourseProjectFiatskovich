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
                <script src="${contextPath}/resources/js/tagcanvas.min.js" type="text/javascript"></script>
                <script type="text/javascript">
                    window.onload = function() {
                        try {
                            TagCanvas.Start('myCanvas','tags',{
                                textColour: '#ff0000',
                                outlineColour: '#ff00ff',
                                reverse: true,
                                depth: 0.8,
                                maxSpeed: 0.05
                            });
                        } catch(e) {
                            // something went wrong, hide the canvas container
                            document.getElementById('myCanvasContainer').style.display = 'none';
                        }
                    };
                </script>
                <!--categories-->


                <div class=" rsidebar span_1_of_left">
                    <h2>Категории</h2>
                <div id="myCanvasContainer">
                    <canvas width="300" height="300" id="myCanvas">
                    </canvas>
                </div>
                <div id="tags">
                    <ul>
                        <c:forEach var="categories" items="${categories}">
                            <li><a href="/product/index/${categories.id}">${categories.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
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
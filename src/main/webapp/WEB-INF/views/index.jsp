<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Магазин электротехники</title>
  <jsp:include page="templates/scripts.jsp"/>
</head>
<body>
<!--header-->
<jsp:include page="templates/header.jsp"/>
<!--content-->
<div class="content">

    <jsp:include page="templates/banner.jsp"/>

    <div class="container">
        <div class="content-top">
            <div class="content-top1">
                <div class="col-md-3 col-md2 animated wow fadeInLeft" data-wow-delay=".5s">
                    <div class="col-md1">
                            <img src="${contextPath}/resources/images/medal-3.jpg" style="width: 100%; height: 100%" alt="" />
                    </div>
                </div>
                <div class="col-md-6 animated wow fadeInDown animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInDown;">
                    <div class="col-md3">
                        <div class="up-t">
                            <h3>Проверено годами</h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-md2 animated wow fadeInRight" data-wow-delay=".5s">
                    <div class="col-md1">
                        <img src="${contextPath}/resources/images/medal-3.jpg" style="width: 100%; height: 100%" alt="" />
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>

            <div class="content-top1">
                <c:forEach var="products" items="${products}">
                <div class="col-md-3 col-md2 animated wow fadeInLeft" data-wow-delay=".5s">
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
    </div>
</div>

<script>
    // Can also be used with $(document).ready()
    $(window).load(function() {
        $('.flexslider').flexslider({
            animation: "slide",
            controlNav: "thumbnails"
        });
    });
</script>

<!--//content-->
<jsp:include page="templates/index_content.jsp"/>

<!--footer-->
<jsp:include page="templates/footer.jsp"/>
<!--footer-->
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 21.02.2017
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница администратора</title>
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
    <div class="content">
        <div class="products">
            <div class="container">
                <h2>Товары</h2>
                <div class="col-md-9">
                    <a href="/admin/addProduct">Добавить продукт</a>
                    <div class="content-top1">
                        <c:forEach var="products" items="${products}">
                            <div class="col-md-4 col-md4">
                                <a href="/admin/edit/${products.id}"><i class="glyphicon glyphicon-edit"></i></a>
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
                    <script type="text/javascript">
                        $(function() {
                            var menu_ul = $('.menu-drop > li > ul'),
                                    menu_a  = $('.menu-drop > li > a');
                            menu_ul.hide();
                            menu_a.click(function(e) {
                                e.preventDefault();
                                if(!$(this).hasClass('active')) {
                                    menu_a.removeClass('active');
                                    menu_ul.filter(':visible').slideUp('normal');
                                    $(this).addClass('active').next().stop(true,true).slideDown('normal');
                                } else {
                                    $(this).removeClass('active');
                                    $(this).next().stop(true,true).slideUp('normal');
                                }
                            });
                        });
                    </script>

                    <div class=" rsidebar span_1_of_left">
                        <h3 class="cate">Пользователи</h3>
                        <ul class="menu-drop">
                            <c:forEach var="users" items="${users}">
                                <li class="item1"><a href="#">${users.username}</a>
                                    <ul class="cute">
                                        <c:forEach var="role" items="${users.roles}">
                                        <li class="subitem1">${role.name}</li>
                                        </c:forEach>
                                            </ul>
                                </li>
                            </c:forEach>
                        </ul>
                        <h3 class="cate"><a href="/admin/report">Отчетность</a></h3>
                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../../views/templates/footer.jsp"/>

</body>
</html>

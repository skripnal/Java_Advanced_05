<%@ page import="ua.skripnal.model.User" %>
<%@ page import="ua.skripnal.eEnum.UserRole" %>
<%
    User user = (User) session.getAttribute("user");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/bucket.css">
    <script src="js/bucket.js"></script>
</head>
<body>

<% if (user.getRole().equals(UserRole.USER.toString())) { %>
<jsp:include page="headers/userPageHeader.jsp"></jsp:include>
<% } %>
<% if (user.getRole().equals(UserRole.ADMIN.toString())) { %>
<jsp:include page="headers/adminPageHeader.jsp"></jsp:include>
<% } %>

    <div class="card">
        <div class="row">
            <div class="col-md-8 cart">
                <div class="title">
                    <div class="row">
                        <div class="col"><h4><b>Корзина</b></h4></div>
                        <div class="col align-self-center text-right text-muted product-count"></div>
                    </div>
                </div>
                <div class="bucket-products">

                </div>


                <div class="back-to-shop"><a href="shop.jsp">&leftarrow; Повернутися в магазин</a></div>
            </div>
            <div class="col-md-4 summary">
                <div><h5><b>Сума</b></h5></div>
                <hr>
                <div class="row">
                    <div class="col product-count" style="padding-left:0;"></div>
                    <div class="col text-right bucket-price"></div>
                </div>
                <form>
                    <p>Доставка</p>
                    <select><option class="text-muted delivery-price"></option></select>
                    <p>Промокод</p>
                    <input id="code" placeholder="Введіть промокод">
                </form>
                <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                    <div class="col">Сума</div>
                    <div class="col text-right bucket-delivery-price"></div>
                </div>
                <button class="btn">Замовити</button>
            </div>
        </div>

    </div>
</body>
</html>

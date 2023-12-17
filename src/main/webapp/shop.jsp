<%@ page import="ua.skripnal.model.User" %>
<%@ page import="ua.skripnal.eEnum.UserRole" %>
<%
    User user = (User) session.getAttribute("user");
%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web-site</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="css/shopCards.css">
    <script src="js/shopCards.js"></script>
</head>
<body>

<% if (user.getRole().equals(UserRole.USER.toString())) { %>
<jsp:include page="headers/userPageHeader.jsp"></jsp:include>
<% } %>
<% if (user.getRole().equals(UserRole.ADMIN.toString())) { %>
<jsp:include page="headers/adminPageHeader.jsp"></jsp:include>
<% } %>

<section class="shop-cards">
    <div class="container py-5">
        <div class="dropdown">
            <button class="btn mb-3" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="icons/filter-button.svg" alt="" style="width: 25px;">
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li>
                    <div class="dropdown-item">Смартфони</div>
                </li>
                <li>
                    <div class="dropdown-item">
                        <input type="checkbox" class="filter-checkbox" id="iphone-checkbox" name="Смартфон" value="iPhone">
                        <label for="iphone-checkbox">iPhone</label>
                    </div>
                </li>
                <li>
                    <div class="dropdown-item">
                        <input type="checkbox" class="filter-checkbox" id="smartphone-samsung-checkbox" name="Смартфон" value="Samsung">
                        <label for="smartphone-samsung-checkbox">Samsung</label>
                    </div>
                </li>
                <li>
                    <div class="dropdown-item">
                        <input type="checkbox" class="filter-checkbox" id="smartphone-xiaomi-checkbox" name="Смартфон" value="Xiaomi">
                        <label for="smartphone-xiaomi-checkbox">Xiaomi</label>
                    </div>
                </li>
            </ul>
        </div>
        <div class="row">

        </div>
    </div>
</section>

</body>
</html>

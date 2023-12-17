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
    <link rel="stylesheet" href="css/singleProduct.css">
    <script src="js/singleProduct.js"></script>

</head>
<body>

<% if (user == null) { %>
<header class="navbar navbar-expand-sm navbar-dark bg-dark p-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">LOGO</a>


        <div class="" id="navbarNavDropdown">
            <ul class="navbar-nav ms-auto ">
                <li class="nav-item">
                    <a class="nav-link mx-2" aria-current="page" href="login.jsp">Увійти</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2" href="registration.jsp">Зареєструватися</a>
                </li>
            </ul>
        </div>
    </div>
</header>
<% } else if (user.getRole().equals(UserRole.USER.toString())) { %>
<jsp:include page="headers/userPageHeader.jsp"></jsp:include>
<% } else if (user.getRole().equals(UserRole.ADMIN.toString())) { %>
<jsp:include page="headers/adminPageHeader.jsp"></jsp:include>
<% } %>




<section class="single-product">
    <div class="container py-5 ">

    </div>
</section>
</body>
</html>
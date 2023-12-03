<%@ page import="ua.skripnal.model.User" %>
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
    <link rel="stylesheet" href="css/userPage.css">
    <script src="js/sidebar.js"></script>
    <script src="js/logOut.js"></script>
</head>
<body>
<header id="wrapper" class="animate">
    <nav class="navbar header-top fixed-top navbar-expand navbar-dark bg-dark">
        <span class="ms-3 navbar-toggler-icon leftmenutrigger"></span>
        <a class="navbar-brand" href="#">LOGO</a>

        <div class="me-3 collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav animate side-nav bg-dark">
                <li class="nav-item">
                    <a class="nav-link" href="addProduct.jsp">Додати продукт</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">кнопка 2</a>
                </li>
            </ul>
            <ul class="navbar-nav margine-left d-md-flex">
                <li class="nav-item dropdown margine-r-100">
                    <a class="nav-link mx-2 dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <%=user.getFirstName()%>
                    </a>
                    <ul class="dropdown-menu bg-dark" aria-labelledby="navbarDropdownMenuLink">
                        <li><a class="dropdown-item bg-dark text-white" id="logOut" href="#">Вийти</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>
</body>
</html>


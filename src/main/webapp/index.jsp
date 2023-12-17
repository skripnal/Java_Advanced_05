<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web site</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="js/shopCards.js"></script>
    <script src="js/index.js"></script>
    <link rel="stylesheet" href="css/shopCards.css">
</head>
<body>
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

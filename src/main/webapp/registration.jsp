<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, minimum-scale=1.0">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Web site</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="css/registration.css">
    <script src="js/registration.js"></script>
</head>
<body>
<header class="navbar navbar-expand-sm navbar-dark bg-dark p-3">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">LOGO</a>


        <div class="" id="navbarNavDropdown">
            <ul class="navbar-nav ms-auto ">
                <li class="nav-item">
                    <a class="nav-link mx-2" aria-current="page" href="login.jsp">Увійти</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link mx-2 active" href="registration.jsp">Зареєструватися</a>
                </li>
            </ul>
        </div>
    </div>
</header>

<div class="alert alert-warning alert-dismissible"></div>

<div class="reg-container mt-5">
    <h2 class="text-center mb-4">Реєстрація</h2>

    <form class="reg-form text-white" method="post">
        <div class="mb-3">
            <label for="firstName" class="form-label">Ім'я:</label>
            <input type="text" class="form-control" id="firstName" name="firstName">
        </div>

        <div class="mb-3">
            <label for="lastName" class="form-label">Прізвище:</label>
            <input type="text" class="form-control" id="lastName" name="lastName">
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email">
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Пароль:</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>

        <button type="submit" class="btn btn-primary" id="register">Зареєструватися</button>
    </form>
</div>

</body>
</html>

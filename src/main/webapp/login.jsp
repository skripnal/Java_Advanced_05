<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Web site</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header class="header">
    <div class="header-logo">LOGO</div>
    <div class="header-links">
        <div class="header-link-container-login"><a href="login.jsp" class="header-link  active-page">Логін</a></div>
        <div class="header-link-container-reg"><a href="registration.jsp" class="header-link">Реєстрація</a></div>
    </div>
</header>

<form action="loginServlet" method="post" class="login-form">
    <div class="login-form-container">
        <label for="email" class="login-form-label">Email:</label>
        <input type="email" name="email" id="email" class="login-form-input">
    </div>
    <div class="login-form-container">
        <label for="password" class="login-form-label">Пароль:</label>
        <input type="password" name="password" id="password" class="login-form-input">
    </div>
    <div class="login-form-container">
        <input type="submit" value="Вхід" class="login-form-submit">
    </div>

</form>
</body>
</html>
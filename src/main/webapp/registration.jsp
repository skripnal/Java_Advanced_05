
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
        <div class="header-link-container-login"><a href="login.jsp" class="header-link">Логін</a></div>
        <div class="header-link-container-reg"><a href="registration.jsp" class="header-link active-page">Реєстрація</a></div>
    </div>
</header>

<form action="registrationServlet" method="post" class="reg-form">
    <div class="reg-form-container">
        <label for="firstName" class="reg-form-label">Ім'я:</label>
        <input type="text" name="firstName" id="firstName" class="reg-form-input">
    </div>
    <div class="reg-form-container">
        <label for="lastName" class="reg-form-label">Прізвище:</label>
        <input type="text" name="lastName" id="lastName" class="reg-form-input">
    </div>
    <div class="reg-form-container">
        <label for="email" class="reg-form-label">Email:</label>
        <input type="email" name="email" id="email" class="reg-form-input">
    </div>
    <div class="reg-form-container">
        <label for="password" class="reg-form-label">Пароль:</label>
        <input type="password" name="password" id="password" class="reg-form-input">
    </div>
    <div class="reg-form-container">
        <input type="submit" value="Зареєструватися" class="reg-form-submit">
    </div>

</form>

</body>
</html>

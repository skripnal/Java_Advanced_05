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
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/addProduct.css">
    <script src="js/addProduct.js"></script>
</head>
<body>

<jsp:include page="headers/adminPageHeader.jsp"></jsp:include>

<main>
    <div class="addProduct-container mt-5">
        <h2 class="text-center mb-4">Додати продукт</h2>

        <form class="addProduct-form text-white" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Назва товару:</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Опис товару:</label>
                <textarea class="form-control text-area-height" id="description" name="description"></textarea>
            </div>

            <div class="mb-3">
                <label for="price" class="form-label">Ціна товару:</label>
                <input type="text" class="form-control" id="price" name="price">
            </div>

            <div class="mb-3">
                <label for="category" class="form-label">Категорія:</label>
                <input type="text" class="form-control" id="category" name="category">
            </div>

            <div class="mb-3">
                <label for="sub_category" class="form-label">Підкатегорія:</label>
                <input type="text" class="form-control" id="sub_category" name="sub_category">
            </div>

            <div class="mb-3">
                <label for="image_path" class="form-label">Шлях до картинки:</label>
                <input type="text" class="form-control" id="image_path" name="image_path">
            </div>

            <button type="submit" class="btn btn-primary" id="addProduct">Додати</button>
        </form>
    </div>
</main>

</body>
</html>

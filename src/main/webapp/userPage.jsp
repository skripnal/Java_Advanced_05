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
    <title>Web site</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<header class="header">
    <div class="header-logo">LOGO</div>
    <div class="header-userPage-link">
        <div class="header-userPage-link-userName"><%=user.getFirstName()%></div>
    </div>
</header>



</body>
</html>

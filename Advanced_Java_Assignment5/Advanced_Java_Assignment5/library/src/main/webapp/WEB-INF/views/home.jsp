<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value='/resources/css/base.css' />" type="text/css">
    <title>Login</title>
</head>
<body>
    <nav class="navbar">
        <div class="nav-content">
            <span class="nav-title">Library Management System</span>
        </div>
    </nav>
    <main class="main">
        <form action="./login" method="post" class="login-form">
            <fieldset>
                <legend>Login</legend>
                <div class="field-container">
                    <label for="username">User Id:</label>
                    <input type="text" name="username" id="username" minlength="5" maxlength="50" class="input-field" autofocus required>
                </div>
                <div class="field-container">
                    <label for="password">Password:</label>
                    <input type="password" name="password" id="password" minlength="4" maxlength="50" class="input-field" required>
                </div>
                <div class="btn-container">
                    <input type="submit" value="Login" class="btn btn-login">
                </div>
            </fieldset>
        </form>
    </main>
    <footer class="footer">&copy; Copyright 2022 - Nagarro Technologys</footer>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="template/header.jsp"/>
    <jsp:include page="template/meta.jsp"/>
</head>
<body>
<div class="desk_center">
    <h1><%= "Введите логин и пароль ^-^" %>
    </h1>
    <br/>
    <form action="main" method="POST"  class="form_center">
        <a>Login:</a>
        <br/> <input type="text" name="login">
        <br/>
        <a>Password:</a>
        <br/> <input type="password" name="password"/>
        <br/>
        <button type="submit" value="login" name="command" >
            Войти
        </button>
    </form>
</div>
</body>
</html>
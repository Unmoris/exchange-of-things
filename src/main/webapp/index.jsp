<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="WEB-INF/template/header.jsp"/>
    <jsp:include page="WEB-INF/template/meta.jsp"/>
</head>
<body>
<div class="desk_center">
    <h1><%= "Войти или Зарегистрироваться!" %>
    </h1>
    <br/>
    <form method="post" action="main" >
        <button value="input" name="command" type="submit">
            Войти
        </button>
    </form>
</div>

</body>
</html>
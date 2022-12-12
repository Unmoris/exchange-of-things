<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean" />
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="template/header/header.jsp"/>
    <jsp:include page="template/header/meta.jsp"/>
</head>
<body>
<div class="desk_center">
    <h1>Введите логин и пароль
    </h1>
    <br/>
    <form method="POST" action="input" class="form_center">
        <input type="hidden" value="login" name=${actions.command}>
        <a>Login:</a>
        <br/> <input type="text" name="login">
        <br/>
        <a>Password:</a>
        <br/> <input type="password" name="password"/>
        <br/>
        <button type="submit" value="enter">
            Войти
        </button>
        <c:if test="${not empty error}">
            <a><b>Ошибка:</b>
                <c:out value="${error}"></c:out>
            </a>
        </c:if>
    </form>
</div>
</body>
</html>
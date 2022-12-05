<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean"/>
<div>
    <h1>МОДЕРАТОР</h1>
    <form method="post">
        <input type="hidden" name="${actions.command}" value="moderator" >
        <button value="info" name=${actions.moderator}>
            Моя информация
        </button>
        <button value="items" name=${actions.moderator}>
            Вещи
        </button>
        <button value="EXCHANGES" name=${actions.moderator}>
            Обмены
        </button>
        <button value="users" name=${actions.moderator}>
            Список пользователей
        </button>
    </form>
</div>

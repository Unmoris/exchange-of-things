<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean"/>
<jsp:useBean id="user" class="ru.rsreu.exchangethings.view.beans.UserBean"/>
<jsp:useBean id="item" class="ru.rsreu.exchangethings.view.beans.ItemBean"/>
<div>
    <h1>МЕНЮ:</h1>
    <form method="post">
        <input type="hidden" name="${actions.command}" value="user" >
        <button value="info" name=${actions.user}>
            Моя информация
        </button>
        <button value="my_items" name=${actions.user}>
            Мои вещи
        </button>
        <button value="EXCHANGE" name=${actions.user}>
            Обмены и заявки
        </button>
        <button value="LIST_ITEMS" name=${actions.user}>
            Список вещей
        </button>
    </form>
</div>
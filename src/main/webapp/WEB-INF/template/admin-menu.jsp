<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean"/>
<jsp:useBean id="user" class="ru.rsreu.exchangethings.view.beans.UserBean"/>
<div>
    <h1>АДМИНИСТРАТОР</h1>
    <form method="post">
        <input type="hidden" name="${actions.command}" value="admin" >
        <button value="info" name=${actions.admin}>
            Моя информация
        </button>
        <button value="add_human" name=${actions.admin}>
            Добавить пользователя
        </button>
        <button value="edit_delete_human" name=${actions.admin}>
            Редактирование и удаление пользователей
        </button>
        <button value="show_authorized_users" name=${actions.admin}>
            Просмотр авторизованных в данный момент
        </button>
    </form>
</div>

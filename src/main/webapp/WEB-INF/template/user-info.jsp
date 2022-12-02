<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="ru.rsreu.exchangethings.view.beans.UserBean"/>
<div>
    <label>
        Логин : ${user.login} </br>
    </label>
    <label>
        Имя: ${user.name} </br>
    </label>
    <label>
        Фамилия ${user.surname} </br>
    </label>
    <label>
        Отчество ${user.patronymic} </br>
    </label>
    <label>
        Роль: ${user.userRole} </br>
    </label>
    <label>
        Статус: ${user.userStatus} </br>
    </label>
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean"/>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="template/header/header.jsp"/>
    <jsp:include page="template/header/meta.jsp"/>
</head>
<body>
<div>
    <c:import url="template/admin-menu.jsp"/>
        <div>
            <form method="post">
                <label>
                    Роль: ${user.userRole}
                </label>  </br> </br>
                <label>
                    Фамилия:
                </label>
                <input value="${user.surname}"  name="surname" class="input_add_user" type="text" maxlength="50"/> </br> </br>
                <label>
                    Имя:
                </label>
                <input value="${user.name}"  name="name" class="input_add_user" type="text" maxlength="50"/> </br> </br>
                <label>
                    Отчество:
                </label>
                <input value="${user.patronymic}"  name="patronymic" class="input_add_user" type="text" maxlength="50"/> </br> </br>
                <label>
                    Логин:
                </label>
                <input value="${user.login}"  name="login" class="input_add_user" type="text" maxlength="50"/> </br> </br>
                <label>
                    Пароль:
                </label>
                <input value="1"  name="password" class="input_add_user" type="password" maxlength="50"/> </br> </br>
                <button type="submit" formmethod="post" name=${actions.admin} value="HUMAN_SAVE_EDIT">
                    Сохранить изменения
                </button> </br>
                <input type="hidden" name="id_user" value="${user.id}">
            </form>
        </div>
</div>
</body>
</html>


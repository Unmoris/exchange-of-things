<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean"/>
<html>
<head>
    <jsp:include page="template/header/header.jsp"/>
</head>
<body>
<div>
    <c:import url="template/admin-menu.jsp"/>
    <div>
        <c:choose>
            <c:when test="${menu_item == 'info'}">
                <div>
                    <form>
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
                    </form>
                </div>
            </c:when>
            <c:when test="${menu_item == 'add_human'}">
            <div>
                <form method="post">
                    <select name="user_role" required="required">
                        <option value="">Администратор</option>
                        <option value="1">Модератор</option>
                        <option value="2">Пользователь</option>
                    </select> </br>
                    <input value="Фамилия"  name="surname" type="text" maxlength="50"/> </br>
                    <input value="Имя"  name="name" type="text" maxlength="50"/> </br>
                    <input value="Отчество"  name="patronymic" type="text" maxlength="50"/> </br>
                    <input value="Логин"  name="login" type="text" maxlength="50"/> </br>
                    <input value="Пароль"  name="password" type="text" maxlength="50"/> </br>
                    <button type="submit" name=${actions.admin} value="human_adding">
                        Добавить
                    </button> </br>
                </form>
            </div>
                <c:forEach var="user" items="${users}">
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'edit_delete_human'}">
                <c:forEach var="user" items="${users}">
                    <div>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'show_authorized_users'}">
                <c:forEach var="user" items="${users}">
                    <div>
                        <form>
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
                        </form>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                Где-то была ошибка
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>

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
        <c:choose>
            <c:when test="${menu_item == 'info'}">
                <div>
                    <form method="post">
                        <div>
                            <label>
                                Логин: ${user.login} </br>
                            </label>
                            <label>
                                Имя: ${user.name} </br>
                            </label>
                            <label>
                                Фамилия: ${user.surname} </br>
                            </label>
                            <label>
                                Отчество: ${user.patronymic} </br>
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
                        <label>
                            Роль:
                        </label>
                        <select name="user_role" required="required">
                            <option value=""></option>
                            <option value="1">Администратор</option>
                            <option value="2">Модератор</option>
                            <option value="3">Пользователь</option>
                        </select> </br> </br>
                        <label>
                            Фамилия:
                        </label>
                        <input value="" name="surname" class="input_add_user" type="text" maxlength="50"/> </br>
                        <label>
                            Имя:
                        </label>
                        <input value="" name="name" type="text" class="input_add_user" maxlength="50"/> </br>
                        <label>
                            Отчество:
                        </label>
                        <input value="" name="patronymic" class="input_add_user" type="text"  maxlength="50"/> </br>
                        <label>
                            Логин:
                        </label>
                        <input value="" name="login" class="input_add_user" type="text" maxlength="50"/> </br>
                        <label>
                            Пароль:
                        </label>
                        <input value="" name="password" class="input_add_user" type="text" maxlength="50"/> </br>
                        <button type="submit" name=${actions.admin} value="ADDING_HUMAN">
                            Добавить
                        </button>
                        </br>
                    </form>
                </div>
                <c:forEach var="user" items="${users}">
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'edit_delete_human'}">
                <c:forEach var="user" items="${users}">
                    <div>
                        <form method="post">
                            <label>
                                Логин: ${user.login}  </br>
                            </label>
                            <label>
                                Имя: ${user.name} </br>
                            </label>
                            <label>
                                Фамилия: ${user.surname} </br>
                            </label>
                            <label>
                                Отчество: ${user.patronymic} </br>
                            </label>
                            <label>
                                Роль: ${user.userRole} </br>
                            </label>
                            <label>
                                Статус: ${user.userStatus} </br>
                            </label>
                            <button name=${actions.admin} type="submit" value="edit_human">
                                Редактировать
                            </button>
                            <button name=${actions.admin} type="submit" value="delete_human">
                                Удалить
                            </button>
                            <input type="hidden" name="id_user" value="${user.id}">
                        </form>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'show_authorized_users'}">
                <c:forEach var="user" items="${users}">
                    <div>
                        <form method="post">
                            <label>
                                Логин: ${user.login} </br>
                            </label>
                            <label>
                                Имя: ${user.name} </br>
                            </label>
                            <label>
                                Фамилия: ${user.surname} </br>
                            </label>
                            <label>
                                Отчество: ${user.patronymic} </br>
                            </label>
                            <label>
                                Роль: ${user.userRole} </br>
                            </label>
                            <label>
                                Статус: ${user.userStatus} </br>
                            </label>
                        </form>
                        </br>
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

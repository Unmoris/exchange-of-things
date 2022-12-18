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
    <c:import url="template/moderator-menu.jsp"/>
    <div>
        <c:choose>
            <c:when test="${menu_item == 'info'}">
                <div>
                    <form method="post">
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
            <c:when test="${menu_item == 'items'}">
                <form method="post">
                </form>
                <c:forEach var="item" items="${items}">
                    <div>
                        <form method="post">
                            <label>
                                Название: ${item.title} </br>
                            </label>
                            <label>
                                Описание ${item.description} </br>
                            </label>
                            <img src="images/${item.image}" width="189" height="100"> </br>
                            <label>
                                Кол-во просмотров: ${item.countViewItem} </br>
                            </label>
                            <c:if test="${item.status eq 'Заблокирована'}">
                                <button name=${actions.moderator} value="UNBLOCK_ITEM">
                                    Разблокировать
                                </button>
                            </c:if>
                            <c:if test="${not (item.status eq 'Заблокирована')}">
                                <button name=${actions.moderator} value="BLOCK_ITEM">
                                    Заблокировать
                                </button>
                            </c:if>
                            <input type="hidden" name="id_item" value="${item.id}">
                        </form>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'exchanges'}">
                <c:forEach var="exchange" items="${exchanges}">
                    <div>
                        <form method="post">
                            <label>
                                Id exchange: ${exchange.id} </br>
                            </label>
                            <label>
                                Время публикации: ${exchange.timePublish} </br>
                            </label>
                            <label>
                                Комментарий: ${exchange.comment} </br>
                            </label>
                            <button name=${actions.moderator} value="end_exchange">
                                Завершить
                            </button>
                            <button name=${actions.moderator} value="cancel_exchange">
                                Отменить
                            </button>
                            <button name=${actions.moderator} value="DELETE_EXCHANGE">
                                Удалить
                            </button>
                            <input type="hidden" name="id_exchange" value="${exchange.id}">
                        </form>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'users'}">
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
                            <c:if test="${user.userStatus eq 'Не заблокирован'}">
                                <button name=${actions.moderator} value="USER_BLOCK">
                                    Заблокировать
                                </button>
                            </c:if>
                            <c:if test="${user.userStatus eq 'Заблокирован'}">
                                <button name=${actions.moderator} value="USER_UNBLOCK">
                                    Разблокировать
                                </button>
                            </c:if>
                            <input type="hidden" name="id_user" value="${user.id}">
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

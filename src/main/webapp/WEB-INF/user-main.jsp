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
    <c:import url="template/user-menu.jsp"/>
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
            <c:when test="${menu_item == 'my_items'}">
                <form method="post">
                    <button type="submit" name=${actions.user} value="item_adding">
                        Добавить вещь
                    </button>
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
                            <c:if test="${item.isHidden}">
                                <button name=${actions.user} value="OPEN_ITEM">
                                    Открыть
                                </button>
                            </c:if>
                            <c:if test="${not item.isHidden}">
                                <button name=${actions.user} value="HIDDEN_ITEM">
                                    Скрыть
                                </button>
                            </c:if>
                            <button name=${actions.user} value="info_item" formmethod="post">
                                Подробнее
                            </button>
                            <input type="hidden" name="id_item" value="${item.id}">
                        </form>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'exchange'}">
                <c:forEach var="exchange" items="${exchanges}">
                    <div>
                        <form method="post">
                            <label>
                                Время публикации: ${exchange.timePublish} </br>
                            </label>
                                <%--                            <label>--%>
                                <%--                                    ${exchange.requestStatus} </br>--%>
                                <%--                            </label>--%>
                            <label>
                                Комментарий: ${exchange.comment} </br>
                            </label>
                            <button name=${actions.user} value="exchange_item_approve">
                                Обменять
                            </button>
                            <button name=${actions.user} value="exchange_item_not_approve">
                                Отменить
                            </button>
                            <input type="hidden" name="id_exchange" value="${exchange.id}">
                        </form>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'list_items'}">
                <c:forEach var="item" items="${items}">
                    <div>
                        <form method="post">
                            <label>
                                Название: ${item.title} </br>
                            </label>
                            <label>
                                Описание: ${item.description} </br>
                            </label>
                            <img src="images/${item.image}" width="189" height="100"></br>
                            <button name=${actions.user} value="CHOICE" formmethod="post">
                                Начать обмен
                            </button>
                            <button name=${actions.user} value="info_item" formmethod="post">
                                Подробнее
                            </button>
                            <input type="hidden" name="id_item" value="${item.id}">
                        </form>
                    </div>
                </c:forEach>
            </c:when>
            <c:when test="${menu_item == 'notifications'}">
                <c:forEach var="item" items="${notifications}">
                    <div>
                        <form method="post">
                            <label>
                                У вас есть сообщение: "${item.message}" </br>
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
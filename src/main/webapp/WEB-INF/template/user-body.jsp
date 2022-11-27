<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${menu_item == 'info'}">
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
                    <%--                <button name="user_action" value="change_info">--%>
                    <%--                Изменить информацию --%>
                    <%--                </button>--%>
            </form>
        </div>
    </c:when>
    <c:when test="${menu_item == 'my_items'}">
        <c:forEach var="item" items="${items}">
            <div>
                <button name="user_action" value="add_item">
                    Добавить вещь
                </button>
                <form>
                    <label>
                        id : ${item.id} </br>
                    </label>
                    <label>
                        Название: ${item.title} </br>
                    </label>
                    <label>
                        Описание ${item.description} </br>
                    </label>
                    <button name="user_action" value="hide_item">
                        <c:if test="${item.isHidden}">
                            Открыть вещь
                        </c:if>
                        <c:if test="${not item.isHidden}">
                            Скрыть вещь
                        </c:if>
                    </button>
                    <input type="hidden" name="id_item" value="${item.id}">
                </form>
            </div>
        </c:forEach>
    </c:when>
    <c:when test="${menu_item == 'exchange'}">
        <c:forEach var="exchange" items="${exchanges}">
            <div>
                <form>
                    <label>
                            ${exchange.id} </br>
                    </label>
                    <label>
                            ${exchange.timePublish} </br>
                    </label>
                    <label>
                            ${exchange.requestStatus} </br>
                    </label>
                    <label>
                            ${exchange.comment} </br>
                    </label>
                    <button name="user_action" value="exchange_item_approve">
                        Обменять
                    </button>
                    <button name="user_action" value="exchange_item_not_approve">
                        Отменить
                    </button>
                    <input type="hidden" name="id_exchange" value="${exchange.id}">
                </form>
            </div>
        </c:forEach>
    </c:when>
    <c:when test="${menu_item == 'list_items'}">
        <c:forEach var="list_items" items="${item}">
            <div>
                <a>
                    Название: ${item.name}</br>
                    Описание: ${item.description} </br>
                    Моя вещь: ${item.itemSender} </br>
                    Обменная вещь: ${item.itemReciver} </br>
                </a>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        Где-то была ошибка
    </c:otherwise>
</c:choose>
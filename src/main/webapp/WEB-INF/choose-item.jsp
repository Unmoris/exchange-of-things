<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean"/>
<jsp:useBean id="user" class="ru.rsreu.exchangethings.view.beans.UserBean"/>
<jsp:useBean id="item" class="ru.rsreu.exchangethings.view.beans.ItemBean"/>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="template/header/header.jsp"/>
    <jsp:include page="template/header/meta.jsp"/>
</head>
<body>
<div>
    <c:import url="template/user-menu.jsp"/>
    <form method="post">
        <button type="submit" name=${actions.user} value="LIST_ITEMS" formmethod="post">
            Отменить обмен
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
                <button name=${actions.user} value="exchange_item">
                    Обменять эту вещь
                </button>
                <input type="hidden" name="id_item" value="${item.id}">
                <label>
                    Комментарий:
                </label>
                <input id="comment" type="text" name="comment">
                <input id="id_exchange" type="hidden" name="id_exchange" value="${id_exchange}">
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>

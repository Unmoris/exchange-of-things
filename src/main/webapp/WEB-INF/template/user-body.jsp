<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${menu_item == 'info'}">
        <div>
            <a>
                Логин : ${user.login} </br>
                Имя: ${user.name}</br>
                Фамилия ${user.surname} </br>
                Отчество ${user.patronymic} </br>
                Роль: ${user.userRole} </br>
                Статус: ${user.userStatus} </br>
            </a>
        </div>
    </c:when>
    <c:when test="${menu_item == 'my_items'}">
        <c:forEach var="item" items="${items}">
            <div>
            <a>
                id : ${item.id} </br>
                Название: ${item.name}</br>
                Описание ${item.description} </br>
            </a>
            </div>

        </c:forEach>
    </c:when>
</c:choose>
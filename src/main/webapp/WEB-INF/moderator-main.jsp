<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean"/>
<html>
<head>
  <jsp:include page="template/header/header.jsp"/>
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
              <button name=${actions.moderator} value="delete_item">
                Удалить
              </button>
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
              <button name=${actions.moderator} value="end_exchange">
                Завершить
              </button>
              <button name=${actions.moderator} value="cancel_exchange">
                Отменить
              </button>
              <button name=${actions.moderator} value="delete_exchange">
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
              <button name=${actions.moderator} value="USER_BLOCK">
                <c:if test="${user.userStatus eq 'разблокирован'}">
                  Заблокировать
                </c:if>
                <c:if test="${user.userStatus eq 'заблокирован'}">
                  Разблокировать
                </c:if>
              </button>
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

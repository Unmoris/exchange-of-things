<%--
  Created by IntelliJ IDEA.
  User: micla
  Date: 19.11.2022
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="template/header/header.jsp"/>
    <jsp:include page="template/header/meta.jsp"/>
</head>
<body>
<h2>Страница пользователя</h2>
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

</body>
</html>

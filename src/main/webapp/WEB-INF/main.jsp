<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: micla
  Date: 04.11.2022
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using GET and POST Method to Read Form Data</title>
</head>

<body>
<h1>MAIN JSP</h1>
<div>
    <form method="post">
        <input type="hidden" name="command" value="menu" >
        <button value="info" name="menu_item">
            Моя информация
        </button>
        <button value="items" name="menu_item">
            Мои вещи
        </button>
        <button value="items" name="menu_item">
            Мои обмены
        </button>
        <button value="search" name="menu_item">
            Поиск вещей
        </button>
    </form>
</div>
<div>
    <ul>
        <li><p><b>First Name:</b>
            ${user.login}
        </p></li>
        <li><p><b>Last Name:</b>
            ${user.surname}
        </p></li>
        <c:if test="${not empty password}">
            <li><p><b>Pass:</b>
                <%= session.getAttribute("password")%>
            </p></li>
        </c:if>
    </ul>
</div>


<form action="main" method="POST">
    Password: <input type="text" name="password">
    <br/>
</form>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="template/header/header.jsp"/>
    <jsp:include page="template/header/meta.jsp"/>
</head>
<body>
<c:import url="template/user-menu.jsp"/>
<div>
    <form method="post">
        <label>
            Название: ${item.title} </br>
        </label>
        <label>
            Описание: ${item.description} </br>
        </label>
        <img src="images/${item.image}" width="189" height="100"> </br>
        <label>
            Время публикации: ${item.publishTime.toString()} </br>
        </label>
        <label>
            Владелец: ${item.owner.login} </br>
        </label>
        <label>
            Количество просмотров: ${item.countViewItem} </br>
        </label>
        <input type="hidden" name="id_item" value="${item.id}">
    </form>
</div>
</body>
</html>

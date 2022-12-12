<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="actions" class="ru.rsreu.exchangethings.view.parameters.ActionBean"/>
<jsp:useBean id="user" class="ru.rsreu.exchangethings.view.beans.UserBean"/>
<jsp:useBean id="item" class="ru.rsreu.exchangethings.view.beans.ItemBean"/>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="template/header/header.jsp"/>
    <jsp:include page="template/header/meta.jsp"/>
</head>
<c:import url="template/user-menu.jsp"/>
<body>
<div>
    <label>
        Добавление вещи:
    </label>
    <form method="post" enctype="multipart/form-data">
        <label>
            Название:
        </label>
        <input value="Вещь"  name="title_item" type="text" maxlength="50">
        <label>
            Описание:
        </label>
        <input value="Красивая вещь"  name="description" type="text" maxlength="300"/>
        <input title="Картинка" name="image" type="file" accept="image/jpeg">
        <button type="submit" name=${actions.user} value="add_item">
            Добавить вещь
        </button>
        <button type="submit" name=${actions.user} value="my_items">
            Отменить добавление
        </button>
    </form>
</div>
</body>
</html>

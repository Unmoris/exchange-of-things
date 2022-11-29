<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form method="post">
        <input type="hidden" name="command" value="user" >
        <button value="info" name="user_action">
            Моя информация
        </button>
        <button value="my_items" name="user_action">
            Мои вещи
        </button>
        <button value="EXCHANGE" name="user_action">
            Обмены и заявки
        </button>
        <button value="LIST_ITEMS" name="user_action">
            Список вещей
        </button>
    </form>
</div>
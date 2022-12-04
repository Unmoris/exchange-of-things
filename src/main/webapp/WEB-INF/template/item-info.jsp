<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="item" class="ru.rsreu.exchangethings.view.beans.ItemBean"/>
<label>
  Название: ${item.title} </br>
</label>
<label>
  Описание ${item.description} </br>
</label>
<img src="images/${item.image}" width="189" height="100">

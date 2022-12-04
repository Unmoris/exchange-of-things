package ru.rsreu.exchangethings.model.helper.Items;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;

public class InfoItemHelper implements Helper {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        UserBean user = new UserBean(1, "m.lapkin", "Миша", "Лапкин", "Ильич", "1", "Пользователь", "Активен");
        ItemBean item = new ItemBean(1,"dsa", "test.png", "das", user, Date.valueOf(LocalDate.now()),1);
        request.setAttribute("item", item);
    }
}

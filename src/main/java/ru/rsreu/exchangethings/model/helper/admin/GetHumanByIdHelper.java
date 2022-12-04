package ru.rsreu.exchangethings.model.helper.admin;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetHumanByIdHelper implements Helper {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("user", new UserBean(1, "m.lapkin", "Миша", "Лапкин", "Ильич", "1", "Пользователь", "Активен"));
    }
}

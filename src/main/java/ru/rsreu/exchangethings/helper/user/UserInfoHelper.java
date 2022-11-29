package ru.rsreu.exchangethings.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.helper.MenuHelper;
import ru.rsreu.exchangethings.helper.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoHelper extends MenuHelper {

    public UserInfoHelper() {
        super("info");
    }

    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("user", new UserBean(1, "m.lapkin", "Миша", "Лапкин", "Ильич", "1", "Пользователь", "Активен"));
        super.includeParamsInScopes(request,response);
    }
}

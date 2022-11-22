package ru.rsreu.exchangethings.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.helper.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class UserInfoHelper extends UserMenuHelper {

    public UserInfoHelper() {
        super("info");
    }

    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("user", new UserBean(1, "m.lapkin", "Миша", "Лапкин", "Ильич", "Пользователь", "Активен"));
        super.includeParamsInScopes(request,response);
    }
}

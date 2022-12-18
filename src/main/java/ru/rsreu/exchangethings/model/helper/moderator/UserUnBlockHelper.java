package ru.rsreu.exchangethings.model.helper.moderator;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.UserStatusEnum;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserUnBlockHelper implements Helper {
    UserService userService = UserService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int id = Integer.parseInt(request.getParameter("id_user"));
        userService.setStatusUser(id, UserStatusEnum.NON_BLOCKED);
    }
}

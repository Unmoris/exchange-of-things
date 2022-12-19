package ru.rsreu.exchangethings.model.helper.admin;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.UserService;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class AuthorizedUsersHelper extends MenuHelper {
    public AuthorizedUsersHelper() {
        super("show_authorized_users");
    }

    UserService userService = UserService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("users", userService.getUsersByAuthorizationStatus(true));
        super.execute(request, response);
    }
}

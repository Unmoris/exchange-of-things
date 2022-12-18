package ru.rsreu.exchangethings.model.helper.moderator;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.mock.GetMockData;
import ru.rsreu.exchangethings.model.service.UserService;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class AllUsersHelper extends MenuHelper {
    public AllUsersHelper() {
        super("users");
    }

    UserService userService = UserService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        List<UserBean> users = userService.getAllUsersByRole(UserRoleEnum.USER);
        request.setAttribute("users", users);
        super.execute(request, response);
    }
}

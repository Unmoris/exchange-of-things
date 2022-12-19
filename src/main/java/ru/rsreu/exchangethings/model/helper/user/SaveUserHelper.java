package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.UserStatusEnum;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class SaveUserHelper implements Helper {
    private UserService userService = UserService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String patronymic = request.getParameter("patronymic");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String isAuthorized = "0";
        String lastLoginTime = LocalDate.now().toString();
        int userRole = UserRoleEnum.getRole(Integer.parseInt(request.getParameter("user_role"))).order; //user_role
        int userStatus = UserStatusEnum.NON_BLOCKED.order;
        userService.insertUser(surname, name, patronymic, login, password, isAuthorized, lastLoginTime, userRole, userStatus);
    }
}

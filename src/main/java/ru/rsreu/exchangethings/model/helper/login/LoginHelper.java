package ru.rsreu.exchangethings.model.helper.login;

import ru.rsreu.exchangethings.model.helper.LoggerHelper;
import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.user.UserInfoHelper;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.mock.TestLogging;
import ru.rsreu.exchangethings.model.service.UserService;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.security.TokenRegistrar;
import ru.rsreu.exchangethings.security.token.TokenInfo;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHelper extends LoggerHelper {
    TestLogging logging;
    UserService userService = UserService.instance;

    TokenRegistrar tokenRegistrar = TokenRegistrar.getInstance();

    public LoginHelper(TestLogging logging) {
        this.logging = logging;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserBean userBean;
        try {
            userBean = userService.login(login, password);
            tokenRegistrar.registration(request, new TokenInfo(userBean.getId(), UserRoleEnum.getRole(userBean.getUserRole())));
        } catch (Exception e) {
            request.setAttribute("error", "Ошибка авторизации");
            throw new IncludeParameterException();
        }
    }
}

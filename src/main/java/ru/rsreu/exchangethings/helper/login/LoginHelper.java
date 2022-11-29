package ru.rsreu.exchangethings.helper.login;

import ru.rsreu.exchangethings.helper.Helper;
import ru.rsreu.exchangethings.helper.LoggerHelper;
import ru.rsreu.exchangethings.helper.beans.UserBean;
import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.helper.user.UserInfoHelper;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.mock.TestLogging;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.security.TokenRegistrar;
import ru.rsreu.exchangethings.security.token.TokenInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHelper extends LoggerHelper {
    TestLogging logging;

    TokenRegistrar tokenRegistrar = TokenRegistrar.getInstance();
    StartHelper start = new StartHelper(SecurityService.instance, new UserInfoHelper());

    public LoginHelper(TestLogging logging) {
        this.logging = logging;
    }

    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        boolean isLogging = logging.login(login, password);
        if (!login.isEmpty() && (!password.isEmpty()) && !isLogging) {
            request.setAttribute("error", "Неверно введён логин");
            throw new IncludeParameterException();
        } else {
            tokenRegistrar.registration(request, new TokenInfo(1, UserRoleEnum.USER));
            start.includeParamsInScopes(request,response);
        }
    }
}

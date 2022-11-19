package ru.rsreu.exchangethings.helper;

import ru.rsreu.exchangethings.helper.beans.UserBean;
import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.mock.TestLogging;
import ru.rsreu.exchangethings.security.TokenRegistrar;
import ru.rsreu.exchangethings.security.token.TokenInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHelper extends LoggerHelper {
    TestLogging logging;

    TokenRegistrar tokenRegistrar = TokenRegistrar.getInstance();

    public LoginHelper(TestLogging logging) {
        this.logging = logging;
    }

    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (!login.isEmpty() && (!password.isEmpty()) && !logging.login(login, password)) {
            request.setAttribute("error", "Неверно введён логин");
            throw new IncludeParameterException();
        } else {
            tokenRegistrar.registration(request, new TokenInfo(1, "1"));
            request.setAttribute("user", new UserBean(1, "l", "l", "l", "l", "l", "l"));
        }
    }
}

package com.example.exchangethings.helper;

import com.example.exchangethings.helper.beans.UserBean;
import com.example.exchangethings.exceptions.IncludeParameterException;
import com.example.exchangethings.model.mock.TestLogging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHelper extends LoggerHelper {
    TestLogging logging;

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
            request.setAttribute("user", new UserBean(1, "l", "l", "l", "l", "l", "l"));
        }
    }
}

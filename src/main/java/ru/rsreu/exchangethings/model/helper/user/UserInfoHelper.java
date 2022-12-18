package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.UserService;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.security.token.TokenInfo;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoHelper extends MenuHelper {

    private UserService userService = UserService.instance;
    public UserInfoHelper() {
        super("info");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        TokenInfo info = securityService.getTokenInfo(request);
        UserBean user = userService.getUserById(info.getUserId());
        request.setAttribute("user", user);
        super.execute(request, response);
    }
}

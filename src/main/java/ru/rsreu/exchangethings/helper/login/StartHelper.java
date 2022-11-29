package ru.rsreu.exchangethings.helper.login;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.helper.Helper;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.security.token.TokenInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartHelper implements Helper {
    private SecurityService securityService;
    private Helper userStartHelper;

    StartHelper(SecurityService securityService, Helper userStartHelper) {
        this.userStartHelper = userStartHelper;
        this.securityService = securityService;
    }

    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        TokenInfo info = securityService.getTokenInfo(request);
        switch (info.getUserRole()) {
            case USER:
                userStartHelper.includeParamsInScopes(request, response);
                break;
            case ADMIN:
                break;
            case MODERATOR:
                break;
        }
    }
}

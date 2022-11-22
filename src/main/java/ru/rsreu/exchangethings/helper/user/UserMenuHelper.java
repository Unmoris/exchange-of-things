package ru.rsreu.exchangethings.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.helper.Helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class UserMenuHelper implements Helper {
    protected String menuParameter;

    public UserMenuHelper(String menuParameter){
        this.menuParameter = menuParameter;
    }
    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("menu_item", menuParameter);
    }
}

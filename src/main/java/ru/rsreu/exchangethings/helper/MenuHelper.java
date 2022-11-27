package ru.rsreu.exchangethings.helper;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class MenuHelper implements Helper {
    protected String menuParameter;

    public MenuHelper(String menuParameter){
        this.menuParameter = menuParameter;
    }
    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("menu_item", menuParameter);
    }
}

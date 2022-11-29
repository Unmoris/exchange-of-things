package ru.rsreu.exchangethings.helper;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuHelper extends IncludeParameterHelper {
    protected String menuParameter;

    public MenuHelper(String menuParameter){
        this.menuParameter = menuParameter;
    }

    @Override
    protected String getNameParameter() {
        return "menu_item";
    }

    @Override
    protected Object getParameter() {
        return menuParameter;
    }
}

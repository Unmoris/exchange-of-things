package ru.rsreu.exchangethings.model.helper;

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

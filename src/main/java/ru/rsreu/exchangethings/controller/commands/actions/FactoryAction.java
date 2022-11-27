package ru.rsreu.exchangethings.controller.commands.actions;

import ru.rsreu.exchangethings.controller.commands.ActionFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FactoryAction implements Action {

    private ActionFactory actionFactory;

    public FactoryAction(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        actionFactory.defineAction(request).execute(request, response);
    }
}

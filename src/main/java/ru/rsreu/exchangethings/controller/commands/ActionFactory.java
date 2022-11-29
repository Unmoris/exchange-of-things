package ru.rsreu.exchangethings.controller.commands;

import ru.rsreu.exchangethings.controller.commands.actions.Action;
import ru.rsreu.exchangethings.controller.commands.actions.ActionLogger;

import javax.servlet.http.HttpServletRequest;

abstract public class ActionFactory {

    protected Action getEmptyAction() {
        return ActionLogger.emptyAction;
    }

    abstract protected String getNameParameter();

    protected String getAction(HttpServletRequest request) {
        String action = "";
        String paramCommand = request.getParameter(this.getNameParameter());

        if (paramCommand != null)
            action = paramCommand;

        return action;
    }


    abstract protected Action detectedAction( String action,HttpServletRequest request);

    public Action defineAction(HttpServletRequest request) {
        Action current = getEmptyAction();
        // извлечение имени команды из запроса
        String action = this.getAction(request);
        if (action.isEmpty()) {
            // если команда не задана в текущем запросе
            return current;
        }
        // получение объекта, соответствующего команде
        try {
            current = this.detectedAction( action,request);
        } catch (IllegalArgumentException e) {
            ActionLogger.logger.warning("wrongAction");
            request.setAttribute("wrongAction", action);
        }
        return current;
    }
}

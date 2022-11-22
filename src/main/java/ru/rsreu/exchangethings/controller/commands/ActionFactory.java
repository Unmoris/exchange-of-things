package ru.rsreu.exchangethings.controller.commands;

import ru.rsreu.exchangethings.controller.commands.actions.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

abstract public class ActionFactory {
    protected Logger logger = Logger.getLogger(this.getClass().getName());

    protected Action getEmptyAction() {
        return new Action() {

            @Override
            public void execute(HttpServletRequest request, HttpServletResponse response) {
                logger.info("empty action: " + request.getContextPath());
            }
        };
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
        logger.info("start factory");
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
            logger.warning("wrongAction");
            request.setAttribute("wrongAction", action);
        }
        return current;
    }
}

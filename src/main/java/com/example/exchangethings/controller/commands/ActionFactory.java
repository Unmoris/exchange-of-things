package com.example.exchangethings.controller.commands;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class ActionFactory {
    static private final String NAME_COMMAND_PARAM = "command";

    private String getCommand(HttpServletRequest request) {
        String command = "";
        String paramCommand = request.getParameter(NAME_COMMAND_PARAM);
        String headerCommand = request.getHeader(NAME_COMMAND_PARAM);

        if (paramCommand != null)
            command = paramCommand;
        if (headerCommand != null)
            command = headerCommand;

        return command;
    }

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = CommandsEnum.EMPTY.getCommand();
// извлечение имени команды из запроса
        String action = getCommand(request);
        if (action == null || action.isEmpty()) {
// если команда не задана в текущем запросе
            return current;
        }
// получение объекта, соответствующего команде
        try {
            CommandsEnum currentEnum = CommandsEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action);
        }
        return current;
    }

}

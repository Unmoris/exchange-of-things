package ru.rsreu.exchangethings.controller.commands;

import ru.rsreu.exchangethings.controller.commands.actions.Action;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory extends ActionFactory {
    static private final String NAME_COMMAND_PARAM = "command";

    @Override
    protected String getNameParameter() {
        return NAME_COMMAND_PARAM;
    }

    @Override
    protected Action getEmptyAction() {
        return CommandsEnum.EMPTY.getAction();
    }

    @Override
    protected Action detectedAction(String action, HttpServletRequest request) {
        CommandsEnum currentEnum = CommandsEnum.valueOf(action.toUpperCase());
        return currentEnum.getAction();
    }

}

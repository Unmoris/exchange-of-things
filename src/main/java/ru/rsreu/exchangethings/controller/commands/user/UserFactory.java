package ru.rsreu.exchangethings.controller.commands.user;

import ru.rsreu.exchangethings.controller.commands.CommandsEnum;
import ru.rsreu.exchangethings.controller.commands.actions.Action;
import ru.rsreu.exchangethings.controller.commands.ActionFactory;
import ru.rsreu.exchangethings.controller.commands.actions.ActionLogger;

import javax.servlet.http.HttpServletRequest;

public class UserFactory extends ActionFactory {
    private static final String NAME_ACTION = "user_action";

    @Override
    protected String getNameParameter() {
        return NAME_ACTION;
    }

    @Override
    protected Action getEmptyAction() {
        return CommandsEnum.EMPTY.getAction();
    }

    @Override
    protected Action detectedAction(String action, HttpServletRequest request) {
        ActionLogger.logger.info("action: " + action);
        ActionLogger.infoAction(request, NAME_ACTION);
        UserActionEnum currentEnum = UserActionEnum.valueOf(action.toUpperCase());
        return currentEnum.getAction();
    }
}

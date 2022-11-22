package ru.rsreu.exchangethings.controller.commands.user;

import ru.rsreu.exchangethings.controller.commands.CommandsEnum;
import ru.rsreu.exchangethings.controller.commands.actions.Action;
import ru.rsreu.exchangethings.controller.commands.ActionFactory;

import javax.servlet.http.HttpServletRequest;

public class UserFactory extends ActionFactory {
    @Override
    protected String getNameParameter() {
        return "user_action";
    }

    @Override
    protected Action getEmptyAction() {
        return CommandsEnum.EMPTY.getAction();
    }

    @Override
    protected Action detectedAction(String action, HttpServletRequest request) {
        logger.info("action: "+ action);
        UserCommands currentEnum = UserCommands.valueOf(action.toUpperCase());
        return currentEnum.getAction();
    }
}

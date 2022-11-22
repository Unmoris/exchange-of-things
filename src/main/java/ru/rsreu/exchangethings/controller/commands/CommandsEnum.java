package ru.rsreu.exchangethings.controller.commands;

import ru.rsreu.exchangethings.controller.commands.actions.Action;
import ru.rsreu.exchangethings.controller.commands.actions.FactoryAction;
import ru.rsreu.exchangethings.controller.commands.actions.ViewAction;
import ru.rsreu.exchangethings.controller.commands.user.UserFactory;
import ru.rsreu.exchangethings.helper.HelperEnum;
import ru.rsreu.exchangethings.helper.LoggerHelper;
import ru.rsreu.exchangethings.helper.login.LoginHelper;
import ru.rsreu.exchangethings.model.mock.TestLogging;
import ru.rsreu.exchangethings.view.CommonForwardView;
import ru.rsreu.exchangethings.view.ViewEnum;

public enum CommandsEnum implements GetAction {
    LOGIN(new ViewAction(ViewEnum.MAIN.getView(), ViewEnum.LOGIN.getView(), HelperEnum.LOGGER.getHelper())),
    INPUT(new ViewAction(ViewEnum.LOGIN.getView(), HelperEnum.LOGGER.getHelper())),
    LOGOUT(new ViewAction(new CommonForwardView(""), HelperEnum.LOGGER.getHelper())),
    EMPTY(new ViewAction(ViewEnum.EMPTY.getView(), HelperEnum.LOGGER.getHelper())),
    USER(new FactoryAction(new UserFactory()));

    private Action action;

    CommandsEnum(Action action) {
        this.action = action;
    }

    @Override
    public Action getAction() {
        return action;
    }
}

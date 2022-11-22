package ru.rsreu.exchangethings.controller.commands.user;

import ru.rsreu.exchangethings.controller.commands.actions.Action;
import ru.rsreu.exchangethings.controller.commands.actions.ViewAction;
import ru.rsreu.exchangethings.controller.commands.GetAction;
import ru.rsreu.exchangethings.helper.HelperEnum;
import ru.rsreu.exchangethings.helper.LoggerHelper;
import ru.rsreu.exchangethings.helper.user.UserInfoHelper;
import ru.rsreu.exchangethings.helper.user.UserItemsHelper;
import ru.rsreu.exchangethings.view.ViewEnum;

public enum UserCommands implements GetAction {
    INFO(new ViewAction(ViewEnum.MAIN.getView(), new UserInfoHelper())),
    MY_ITEMS(new ViewAction(ViewEnum.MAIN.getView(), new UserItemsHelper())),
    EXCHANGE(new ViewAction(ViewEnum.EMPTY.getView(), HelperEnum.LOGGER.getHelper())),
    LIST_ITEMS(new ViewAction(ViewEnum.EMPTY.getView(), HelperEnum.LOGGER.getHelper()));

    Action action;

    UserCommands(Action action) {
        this.action = action;
    }

    @Override
    public Action getAction() {
        return action;
    }
}

package ru.rsreu.exchangethings.controller.commands.user;

import ru.rsreu.exchangethings.controller.commands.actions.Action;
import ru.rsreu.exchangethings.controller.commands.actions.ViewAction;
import ru.rsreu.exchangethings.controller.commands.GetAction;
import ru.rsreu.exchangethings.helper.HelperEnum;
import ru.rsreu.exchangethings.helper.user.UserInfoHelper;
import ru.rsreu.exchangethings.helper.user.UserItemsHelper;
import ru.rsreu.exchangethings.view.ViewEnum;

public enum UserActionEnum implements GetAction {
    INFO(new ViewAction(ViewEnum.MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    MY_ITEMS(new ViewAction(ViewEnum.MAIN.getView(), HelperEnum.USER_ITEMS.getHelper())),
    EXCHANGE(new ViewAction(ViewEnum.MAIN.getView(), HelperEnum.USER_EXCHANGES.getHelper())),
    LIST_ITEMS(new ViewAction(ViewEnum.MAIN.getView(), HelperEnum.USER_LIST_ITEMS.getHelper()));

    Action action;

    UserActionEnum(Action action) {
        this.action = action;
    }

    @Override
    public Action getAction() {
        return action;
    }
}

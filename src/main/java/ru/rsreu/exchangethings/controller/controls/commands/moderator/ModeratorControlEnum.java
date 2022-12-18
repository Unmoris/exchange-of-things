package ru.rsreu.exchangethings.controller.controls.commands.moderator;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.GetControl;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.Page;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum ModeratorControlEnum implements GetControl {
    INFO(PageEnum.MODERATOR_MAIN.getView(), HelperEnum.USER_INFO.getHelper()),
    USERS(PageEnum.MODERATOR_MAIN.getView(), HelperEnum.ALL_USERS.getHelper()),
    EXCHANGES(PageEnum.MODERATOR_MAIN.getView(), HelperEnum.ALL_EXCHANGES.getHelper()),
    ITEMS(PageEnum.MODERATOR_MAIN.getView(), HelperEnum.ALL_ITEMS.getHelper()),
    USER_UNBLOCK(PageEnum.SEND_REDIRECT_MODERATOR.getView(), HelperEnum.USER_UNBLOCK.getHelper()),
    USER_BLOCK(PageEnum.SEND_REDIRECT_MODERATOR.getView(), HelperEnum.USER_BLOCK.getHelper()),
    CANCEL_EXCHANGE(PageEnum.SEND_REDIRECT_MODERATOR.getView(), HelperEnum.CANCEL_EXCHANGE.getHelper()),
    DELETE_EXCHANGE(PageEnum.SEND_REDIRECT_MODERATOR.getView(), HelperEnum.DELETE_REQUEST.getHelper()),
    END_EXCHANGE(PageEnum.SEND_REDIRECT_MODERATOR.getView(), HelperEnum.APPROVE_EXCHANGE.getHelper()),
    BLOCK_ITEM(PageEnum.SEND_REDIRECT_MODERATOR.getView(), HelperEnum.BLOCK_ITEM.getHelper()),
    UNBLOCK_ITEM(PageEnum.SEND_REDIRECT_MODERATOR.getView(), HelperEnum.UNBLOCK_ITEM.getHelper());

    Control control;

    ModeratorControlEnum(Control control) {
        this.control = control;
    }

    ModeratorControlEnum(Page commonPage, Helper... helpers) {
        this.control = new ViewControl(commonPage, helpers);
    }


    @Override
    public Control getControl() {
        return control;
    }
}

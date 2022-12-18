package ru.rsreu.exchangethings.controller.controls.commands.user;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.GetControl;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum UserControlEnum implements GetControl {
    INFO(new ViewControl(PageEnum.USER_MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    MY_ITEMS(new ViewControl(PageEnum.USER_MAIN.getView(), HelperEnum.USER_ITEMS.getHelper())),
    EXCHANGE(new ViewControl(PageEnum.USER_MAIN.getView(), HelperEnum.USER_EXCHANGES.getHelper())),
    LIST_ITEMS(new ViewControl(PageEnum.USER_MAIN.getView(), HelperEnum.LIST_ITEMS_FOR_USER.getHelper())),
    ITEM_ADDING(new ViewControl(PageEnum.ADD_ITEM.getView())),
    CHOICE(new ViewControl(PageEnum.CHOOSE_ITEM_FOR_EXCHANGE.getView(), HelperEnum.CHOOSE_ITEMS.getHelper(), HelperEnum.USER_ITEMS.getHelper())),
    HIDDEN_ITEM(new ViewControl(PageEnum.USER_MAIN.getView(), HelperEnum.HIDE_ITEM.getHelper(), HelperEnum.USER_ITEMS.getHelper())),
    OPEN_ITEM(new ViewControl(PageEnum.USER_MAIN.getView(), HelperEnum.OPEN_ITEM.getHelper(), HelperEnum.USER_ITEMS.getHelper())),
    EXCHANGE_ITEM(new ViewControl(PageEnum.SEND_REDIRECT_USER.getView(), HelperEnum.START_EXCHANGE_ITEM.getHelper(), HelperEnum.USER_ITEMS.getHelper())),
    ADD_ITEM(new ViewControl(PageEnum.SEND_REDIRECT_USER.getView(), HelperEnum.LIST_ITEMS_FOR_USER.getHelper(), HelperEnum.ADD_ITEM.getHelper())),
    INFO_ITEM(new ViewControl(PageEnum.INFO_ITEM.getView(), HelperEnum.ITEM_INFO.getHelper())),
    EXCHANGE_ITEM_APPROVE(new ViewControl(PageEnum.SEND_REDIRECT_USER.getView(), HelperEnum.APPROVE_EXCHANGE.getHelper())),
    EXCHANGE_ITEM_NOT_APPROVE(new ViewControl(PageEnum.SEND_REDIRECT_USER.getView(), HelperEnum.CANCEL_EXCHANGE.getHelper()));
    Control control;

    UserControlEnum(Control control) {
        this.control = control;
    }

    @Override
    public Control getControl() {
        return control;
    }
}

package ru.rsreu.exchangethings.controller.controls.commands.user;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.GetControl;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum UserControlEnum implements GetControl {
    INFO(new ViewControl(PageEnum.MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    MY_ITEMS(new ViewControl(PageEnum.MAIN.getView(), HelperEnum.USER_ITEMS.getHelper())),
    EXCHANGE(new ViewControl(PageEnum.MAIN.getView(), HelperEnum.USER_EXCHANGES.getHelper())),
    LIST_ITEMS(new ViewControl(PageEnum.MAIN.getView(), HelperEnum.USER_LIST_ITEMS.getHelper())),
    ITEM_ADDING(new ViewControl(PageEnum.ADD_ITEM.getView())),
    CHOICE(new ViewControl(PageEnum.CHOOSE_ITEM_FOR_EXCHANGE.getView(), HelperEnum.USER_ITEMS.getHelper())),
    EXCHANGE_ITEM(new ViewControl(PageEnum.MAIN.getView(), HelperEnum.LOGGER.getHelper())),
    ADD_ITEM(new ViewControl(PageEnum.MAIN.getView(), HelperEnum.USER_LIST_ITEMS.getHelper(), HelperEnum.ADD_ITEM.getHelper()));
    Control control;

    UserControlEnum(Control control) {
        this.control = control;
    }

    @Override
    public Control getControl() {
        return control;
    }
}

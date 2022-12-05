package ru.rsreu.exchangethings.controller.controls.commands.moderator;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.GetControl;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum ModeratorControlEnum implements GetControl {
    INFO(new ViewControl(PageEnum.MODERATOR_MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    USERS(new ViewControl(PageEnum.MODERATOR_MAIN.getView(), HelperEnum.ALL_USERS.getHelper())),
    EXCHANGES(new ViewControl(PageEnum.MODERATOR_MAIN.getView(), HelperEnum.ALL_EXCHANGES.getHelper())),
    ITEMS(new ViewControl(PageEnum.MODERATOR_MAIN.getView(), HelperEnum.ALL_ITEMS.getHelper()));

    Control control;

    ModeratorControlEnum(Control control) {
        this.control = control;
    }

    @Override
    public Control getControl() {
        return control;
    }
}

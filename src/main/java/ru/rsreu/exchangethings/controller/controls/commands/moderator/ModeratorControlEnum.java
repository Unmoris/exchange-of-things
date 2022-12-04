package ru.rsreu.exchangethings.controller.controls.commands.moderator;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.GetControl;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum ModeratorControlEnum implements GetControl {
    INFO(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    USERS(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    EXCHANGES(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    ITEMS(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.USER_INFO.getHelper()));

    Control control;

    ModeratorControlEnum(Control control) {
        this.control = control;
    }

    @Override
    public Control getControl() {
        return control;
    }
}

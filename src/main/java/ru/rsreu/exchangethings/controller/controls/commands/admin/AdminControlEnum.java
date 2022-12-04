package ru.rsreu.exchangethings.controller.controls.commands.admin;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.GetControl;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum AdminControlEnum implements GetControl {
    INFO(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    ADD_HUMAN(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.ADD_HUMAN.getHelper())),
    EDIT_DELETE_HUMAN(new ViewControl(PageEnum.ADMIN_MAIN.getView())),
    SHOW_AUTHORIZED_USERS(new ViewControl(PageEnum.ADMIN_MAIN.getView()));

    Control control;

    AdminControlEnum(Control control) {
        this.control = control;
    }

    @Override
    public Control getControl() {
        return control;
    }
}

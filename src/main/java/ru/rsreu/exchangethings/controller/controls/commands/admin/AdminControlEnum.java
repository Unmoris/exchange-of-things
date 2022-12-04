package ru.rsreu.exchangethings.controller.controls.commands.admin;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.GetControl;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum AdminControlEnum implements GetControl {
    INFO(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.USER_INFO.getHelper())),
    ADD_HUMAN(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.ADD_HUMAN.getHelper())),
    ADDING_HUMAN(new ViewControl(PageEnum.SEND_REDIRECT_ADMIN.getView())),
    EDIT_DELETE_HUMAN(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.EDIT_DELETE_HUMANS.getHelper())),
    EDIT_HUMAN(new ViewControl(PageEnum.EDIT_HUMAN.getView(), HelperEnum.EDIT_HUMAN.getHelper())),
    DELETE_HUMAN(new ViewControl(PageEnum.SEND_REDIRECT_ADMIN.getView())),
    SHOW_AUTHORIZED_USERS(new ViewControl(PageEnum.ADMIN_MAIN.getView(), HelperEnum.SHOW_AUTHORIZED_HUMAN.getHelper()));

    Control control;

    AdminControlEnum(Control control) {
        this.control = control;
    }

    @Override
    public Control getControl() {
        return control;
    }
}

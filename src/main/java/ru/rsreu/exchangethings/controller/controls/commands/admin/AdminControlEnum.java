package ru.rsreu.exchangethings.controller.controls.commands.admin;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.GetControl;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.Page;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum AdminControlEnum implements GetControl {
    INFO(PageEnum.ADMIN_MAIN.getView(), HelperEnum.USER_INFO.getHelper()),
    ADD_HUMAN(PageEnum.ADMIN_MAIN.getView(), HelperEnum.ADD_HUMAN.getHelper()),
    ADDING_HUMAN(PageEnum.SEND_REDIRECT_ADMIN.getView(), HelperEnum.HUMAN_SAVE.getHelper()),
    EDIT_DELETE_HUMAN(PageEnum.ADMIN_MAIN.getView(), HelperEnum.EDIT_DELETE_HUMANS.getHelper()),
    EDIT_HUMAN(PageEnum.EDIT_HUMAN.getView(), HelperEnum.EDIT_HUMAN.getHelper()),
    DELETE_HUMAN(PageEnum.SEND_REDIRECT_ADMIN.getView(), HelperEnum.DELETE_USER.getHelper()),
    SHOW_AUTHORIZED_USERS(PageEnum.ADMIN_MAIN.getView(), HelperEnum.SHOW_AUTHORIZED_HUMAN.getHelper()),
    HUMAN_SAVE_EDIT(PageEnum.SEND_REDIRECT_ADMIN.getView(), HelperEnum.HUMAN_SAVE_EDIT.getHelper());

    Control control;

    AdminControlEnum(Control control) {
        this.control = control;
    }

    AdminControlEnum(Page commonPage, Helper... helpers) {
        this.control = new ViewControl(commonPage, helpers);
    }


    @Override
    public Control getControl() {
        return control;
    }
}

package ru.rsreu.exchangethings.controller.controls.commands;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.FactoryControl;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.admin.AdminFactory;
import ru.rsreu.exchangethings.controller.controls.commands.moderator.ModeratorFactory;
import ru.rsreu.exchangethings.model.helper.user.UserFactory;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum CommandsControlEnum implements GetControl {
    LOGIN(new ViewControl(PageEnum.MAIN_PAGE_FOR_USERS.getView(), PageEnum.LOGIN.getView(), HelperEnum.LOGIN.getHelper())),
    INPUT(new ViewControl(PageEnum.LOGIN.getView(), HelperEnum.LOGGER.getHelper())),
    LOGOUT(new ViewControl(PageEnum.LOGIN.getView(), HelperEnum.LOGGER.getHelper())),
    EMPTY(new ViewControl(PageEnum.EMPTY.getView(), HelperEnum.LOGGER.getHelper())),
    USER(new FactoryControl(new UserFactory())),
    MODERATOR(new FactoryControl(new ModeratorFactory())),

    ADMIN(new FactoryControl(new AdminFactory()));

    private Control control;

    CommandsControlEnum(Control control) {
        this.control = control;
    }

//    CommandsControlEnum(FactoryControl factoryAction, String nameParameter) {
//        ChooserEmptyControl.addStandardControl(nameParameter, factoryAction);
//        this.control = factoryAction;
//    }

    @Override
    public Control getControl() {
        return control;
    }
}

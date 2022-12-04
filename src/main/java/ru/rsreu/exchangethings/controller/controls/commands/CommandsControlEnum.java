package ru.rsreu.exchangethings.controller.controls.commands;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.FactoryControl;
import ru.rsreu.exchangethings.controller.controls.ViewControl;
import ru.rsreu.exchangethings.controller.controls.commands.user.UserFactory;
import ru.rsreu.exchangethings.view.parameters.ControlNames;
import ru.rsreu.exchangethings.model.helper.HelperEnum;
import ru.rsreu.exchangethings.view.pages.CommonForwardPage;
import ru.rsreu.exchangethings.view.pages.PageEnum;

public enum CommandsControlEnum implements GetControl {
    LOGIN(new ViewControl(PageEnum.MAIN.getView(), PageEnum.LOGIN.getView(), HelperEnum.LOGIN.getHelper())),
    INPUT(new ViewControl(PageEnum.LOGIN.getView(), HelperEnum.LOGGER.getHelper())),
    LOGOUT(new ViewControl(PageEnum.LOGIN.getView(), HelperEnum.LOGGER.getHelper())),
    EMPTY(new ViewControl(PageEnum.EMPTY.getView(), HelperEnum.LOGGER.getHelper())),
    USER(new FactoryControl(new UserFactory()));

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

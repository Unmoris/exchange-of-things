package ru.rsreu.exchangethings.controller.controls.commands.admin;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.LoggerControl;
import ru.rsreu.exchangethings.controller.controls.commands.ControlFactory;
import ru.rsreu.exchangethings.controller.controls.commands.user.UserControlEnum;
import ru.rsreu.exchangethings.view.parameters.ControlNames;

import javax.servlet.http.HttpServletRequest;

public class AdminFactory extends ControlFactory {
    @Override
    protected String getNameParameter() {
        return ControlNames.CONTROL_ADMIN;
    }

    @Override
    protected Control getEmptyControl(HttpServletRequest request) {
        return AdminControlEnum.INFO.getControl();
    }

    @Override
    protected Control detectedControl(String control, HttpServletRequest request) {
        LoggerControl.logger.info("control: " + control);
        LoggerControl.infoControl(request, ControlNames.CONTROL_ADMIN);
        AdminControlEnum currentEnum = AdminControlEnum.valueOf(control.toUpperCase());
        return currentEnum.getControl();
    }

}

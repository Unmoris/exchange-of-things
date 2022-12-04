package ru.rsreu.exchangethings.controller.controls.commands.user;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.commands.ControlFactory;
import ru.rsreu.exchangethings.controller.controls.LoggerControl;
import ru.rsreu.exchangethings.view.parameters.ControlNames;

import javax.servlet.http.HttpServletRequest;

public class UserFactory extends ControlFactory {

    @Override
    protected String getNameParameter()  {
        return ControlNames.CONTROL_USER;
    }

    @Override
    protected Control getEmptyControl(HttpServletRequest request) {
        return UserControlEnum.INFO.getControl();
    }

    @Override
    protected Control detectedControl(String control, HttpServletRequest request) {
        LoggerControl.logger.info("control: " + control);
        LoggerControl.infoControl(request, ControlNames.CONTROL_USER);
        UserControlEnum currentEnum = UserControlEnum.valueOf(control.toUpperCase());
        return currentEnum.getControl();
    }
}

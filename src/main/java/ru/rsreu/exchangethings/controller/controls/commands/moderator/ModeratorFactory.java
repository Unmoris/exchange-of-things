package ru.rsreu.exchangethings.controller.controls.commands.moderator;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.LoggerControl;
import ru.rsreu.exchangethings.controller.controls.commands.ControlFactory;
import ru.rsreu.exchangethings.controller.controls.commands.user.UserControlEnum;
import ru.rsreu.exchangethings.view.parameters.ControlNames;

import javax.servlet.http.HttpServletRequest;

public class ModeratorFactory extends ControlFactory {
    @Override
    protected String getNameParameter() {
        return ControlNames.CONTROL_MODERATOR;
    }

    @Override
    protected Control getEmptyControl(HttpServletRequest request)  {
        return ModeratorControlEnum.INFO.getControl();
    }


    @Override
    protected Control detectedControl(String control, HttpServletRequest request) {
        LoggerControl.logger.info("control: " + control);
        LoggerControl.infoControl(request, ControlNames.CONTROL_USER);
        ModeratorControlEnum currentEnum = ModeratorControlEnum.valueOf(control.toUpperCase());
        return currentEnum.getControl();
    }
}

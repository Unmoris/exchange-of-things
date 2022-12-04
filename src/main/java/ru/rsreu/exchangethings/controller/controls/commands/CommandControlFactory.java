package ru.rsreu.exchangethings.controller.controls.commands;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.view.parameters.ControlNames;

import javax.servlet.http.HttpServletRequest;

public class CommandControlFactory extends ControlFactory {


    @Override
    protected String getNameParameter() {
        return ControlNames.CONTROL_COMMAND;
    }

    @Override
    protected Control getEmptyControl(HttpServletRequest request) {
        return CommandsControlEnum.EMPTY.getControl();
    }

    @Override
    protected Control detectedControl(String control, HttpServletRequest request) {
        CommandsControlEnum currentEnum = CommandsControlEnum.valueOf(control.toUpperCase());
        return currentEnum.getControl();
    }

}

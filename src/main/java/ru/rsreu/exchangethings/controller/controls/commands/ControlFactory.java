package ru.rsreu.exchangethings.controller.controls.commands;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.LoggerControl;

import javax.servlet.http.HttpServletRequest;

abstract public class ControlFactory {


    protected Control getEmptyControl(HttpServletRequest request) {
        return LoggerControl.emptyControl;
    }

    abstract protected String getNameParameter();

    protected String getControlByRequestParameter(HttpServletRequest request) {
        String control = "";
        String paramCommand = request.getParameter(this.getNameParameter());
        if (paramCommand != null)
            control = paramCommand;
        return control;
    }

    protected String getControlByRequestAttribute(HttpServletRequest request) {
        String control = "";
        String paramCommand = (String) request.getAttribute(this.getNameParameter());
        if (paramCommand != null)
            control = paramCommand;
        return control;
    }

    abstract protected Control detectedControl(String control, HttpServletRequest request);

    public Control defineControl(HttpServletRequest request) {
        Control current = this.getEmptyControl(request);
        // извлечение имени команды из запроса
        String control = this.getControlByRequestParameter(request);
        if (control.isEmpty())
            control = this.getControlByRequestAttribute(request);

        if (control.isEmpty()) {
            // если команда не задана в текущем запросе
            return current;
        }
        // получение объекта, соответствующего команде
        try {
            current = this.detectedControl(control, request);
        } catch (IllegalArgumentException e) {
            LoggerControl.logger.warning("wrongAction");
            request.setAttribute("wrongAction", control);
        }
        return current;
    }
}

package ru.rsreu.exchangethings.controller.controls.commands;

import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.LoggerControl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

abstract public class ControlFactory {

    protected Control getEmptyControl(HttpServletRequest request) {
        return LoggerControl.emptyControl;
    }

    abstract protected String getNameParameter();

    protected String getControl(HttpServletRequest request) {
        String control = "";
        String paramCommand = request.getParameter(this.getNameParameter());
        if (paramCommand != null)
            control = paramCommand;
        return control;
    }

    abstract protected Control detectedControl(String control, HttpServletRequest request);

    public Control defineControl(HttpServletRequest request) {
        Control current = getEmptyControl(request);
        // извлечение имени команды из запроса
        String control = this.getControl(request);
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

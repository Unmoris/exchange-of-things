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

    abstract protected Control detectedControl(String control, HttpServletRequest request);

    protected void getControlByPath(HttpServletRequest request){
        String path = request.getRequestURI();
        String contextPath = request.getContextPath() + '/';
        String newPath = path.replace(contextPath,"");
//        System.out.println(contextPath);
//        System.out.println(path);
//        System.out.println(newPath);
    }
    public Control defineControl(HttpServletRequest request) {
        this.getControlByPath(request);
        Control current = getEmptyControl(request);
        // извлечение имени команды из запроса
        String control = this.getControlByRequestParameter(request);
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

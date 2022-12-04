package ru.rsreu.exchangethings.controller.controls.commands;

import ru.rsreu.exchangethings.controller.controls.Control;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ChooserStandardCommand {
    private ChooserStandardCommand() {
    }
    private static Map<String, Control> controlHashMap = new HashMap<>();

    public static void addStandardControl(String controlName, Control control) {
        controlHashMap.put(controlName, control);
    }

    private static Control chooseStandardControl(String controlName) {
        Control result = controlHashMap.get(controlName);
        if (result == null) {
            result = CommandsControlEnum.EMPTY.getControl();
        }
        return result;
    }

    public static Control chooseStandardControl(HttpServletRequest request) {
        Enumeration<String> parameters = request.getParameterNames();
        if (parameters.hasMoreElements())
            do {
                String parameter = parameters.nextElement();
                if (controlHashMap.containsKey(parameter))
                    return chooseStandardControl(parameter);
            } while (parameters.hasMoreElements());
        return CommandsControlEnum.EMPTY.getControl();
    }

}

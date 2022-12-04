package ru.rsreu.exchangethings.controller.controls;

import ru.rsreu.exchangethings.controller.controls.commands.ControlFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FactoryControl implements Control {

    private ControlFactory controlFactory;

    public FactoryControl(ControlFactory controlFactory) {
        this.controlFactory = controlFactory;
    }

    @Override
    public void control(HttpServletRequest request, HttpServletResponse response) {
        controlFactory.defineControl(request).control(request, response);
    }
}

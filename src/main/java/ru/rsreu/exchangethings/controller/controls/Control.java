package ru.rsreu.exchangethings.controller.controls;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
    public void control(HttpServletRequest request, HttpServletResponse response);
}

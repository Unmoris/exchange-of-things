package ru.rsreu.exchangethings.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionCommand {
    public void execute(HttpServletRequest request, HttpServletResponse response);
}

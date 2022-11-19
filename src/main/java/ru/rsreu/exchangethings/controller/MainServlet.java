package ru.rsreu.exchangethings.controller;

import ru.rsreu.exchangethings.controller.commands.ActionCommand;
import ru.rsreu.exchangethings.controller.commands.ActionFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
        command.execute(request, response);
    }

    public void destroy() {
    }
}
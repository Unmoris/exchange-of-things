package ru.rsreu.exchangethings.controller;

import ru.rsreu.exchangethings.controller.commands.actions.Action;
import ru.rsreu.exchangethings.controller.commands.CommandFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    private final CommandFactory client = new CommandFactory();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        Action command = client.defineAction(request);
        command.execute(request, response);
    }

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }


    public void destroy() {
    }
}
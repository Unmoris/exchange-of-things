package ru.rsreu.exchangethings.controller;

import ru.rsreu.exchangethings.configuration.PathToDirectoryImages;
import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.commands.CommandControlFactory;
import ru.rsreu.exchangethings.view.parameters.ActionBean;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
    private final CommandControlFactory client = new CommandControlFactory();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        Control command = client.defineControl(request);
        command.control(request, response);
    }

    public void init() {
        ServletContext context = this.getServletContext();
        context.setAttribute("actions", new ActionBean());
        PathToDirectoryImages.setPath(context.getRealPath("/"));
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
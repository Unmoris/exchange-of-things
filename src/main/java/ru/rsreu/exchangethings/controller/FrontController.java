package ru.rsreu.exchangethings.controller;

import ru.rsreu.exchangethings.configuration.PathToDirectoryImages;
import ru.rsreu.exchangethings.controller.controls.Control;
import ru.rsreu.exchangethings.controller.controls.commands.CommandControlFactory;
import ru.rsreu.exchangethings.model.service.UserService;
import ru.rsreu.exchangethings.view.parameters.ActionBean;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
/**
 * A class that implements design pattern "FrontController".
 * It is Application Controller.
 */
public class FrontController extends HttpServlet {
    /** Variable that instantiates an object factory
     */
    private final CommandControlFactory client = new CommandControlFactory();
    /**
     * Variable that instantiates an object userService
     */
    private UserService userService = UserService.instance;
    /**
     * Method that defines the command
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        Control command = client.defineControl(request);
        command.control(request, response);
    }

    /**
     * Method that initializes data and prepares for processing requests
     */
    public void init() {
        ServletContext context = this.getServletContext();
        context.setAttribute("actions", new ActionBean());
        PathToDirectoryImages.setPath(context.getRealPath("/"));
        userService.updateAllUserAuth();
    }
    /** Method that handles GET requests
     * @param request - Lower bound of the range of generated random numbers
     * @param response - Upper bound of the range of generated random numbers
     * @throws  UnsupportedEncodingException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        processRequest(request, response);
    }
    /** Method that handles POST requests
     * @param request - Lower bound of the range of generated random numbers
     * @param response - Upper bound of the range of generated random numbers
     * @throws  UnsupportedEncodingException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        processRequest(request, response);
    }

    /**
     * Method that releases the resources occupied by the servlet.
     */
    public void destroy() {
    }
}
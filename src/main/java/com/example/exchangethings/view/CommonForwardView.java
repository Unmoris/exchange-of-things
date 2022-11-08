package com.example.exchangethings.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class CommonForwardView extends CommonView {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public CommonForwardView(String initPathToJsp) {
        super(initPathToJsp);
    }


    private void forwardToJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServletContext servletContext = request.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(pathToJsp);
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            tryCatchIoException(() -> response.sendError(500));
        } catch (IOException ioException) {
            logger.warning(ioException.getMessage());
        }
    }

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
        this.forwardToJsp(request, response);
    }

}

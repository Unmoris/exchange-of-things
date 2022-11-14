package com.example.exchangethings.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

abstract public class CommonView implements View {

    protected Logger logger = Logger.getLogger(this.getClass().getName());

    protected String pathToPage;


    protected CommonView(String initPathToJsp) {
        pathToPage = initPathToJsp;
    }

    protected void forwardToJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServletContext servletContext = request.getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(pathToPage);
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            logger.warning(e.getMessage());
            tryCatchIoException(() -> response.sendError(503));
        } catch (IOException ioException) {
            logger.warning(ioException.getMessage());
        }
    }

    protected void tryCatchIoException(RunCatheIoException executor) {
        try {
            executor.run();
        } catch (IOException ioException) {
            logger.warning(ioException.getMessage());
        }
    }
}

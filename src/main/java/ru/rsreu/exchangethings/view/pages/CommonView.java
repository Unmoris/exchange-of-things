package ru.rsreu.exchangethings.view.pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

abstract public class CommonView implements Page {

    protected Logger logger = Logger.getLogger(this.getClass().getName());

    protected String pathToPage;


    protected CommonView(String initPathToJsp) {
        pathToPage = initPathToJsp;
    }

    protected void forwardToJsp(HttpServletRequest request, HttpServletResponse response) {
        try {
            logger.info("forward to " + pathToPage);
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

    protected void sendRedirect(HttpServletRequest request, HttpServletResponse response) {
        try {
            String path = request.getServletContext().getContextPath() + pathToPage;
            logger.info("SEND REDIRECT TO: " + pathToPage);
            response.sendRedirect(path);
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

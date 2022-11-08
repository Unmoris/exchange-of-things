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

    protected String pathToJsp;

    protected CommonView(String initPathToJsp) {
        pathToJsp = initPathToJsp;
    }

    protected void tryCatchIoException(RunCatheIoException executor) {
        try {
            executor.run();
        } catch (IOException ioException) {
            logger.warning(ioException.getMessage());
        }
    }


}

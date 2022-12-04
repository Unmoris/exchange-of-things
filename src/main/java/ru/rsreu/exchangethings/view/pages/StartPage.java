package ru.rsreu.exchangethings.view.pages;

import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.security.SecurityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class StartPage implements Page {
    protected Logger logger = Logger.getLogger(this.getClass().getName());
    String pathToPageUser;
    String pathToPageAdmin;
    String pathToPageModerator;

    public StartPage(String pathToPageUser, String pathToPageAdmin, String pathToPageModerator) {
        this.pathToPageUser = pathToPageUser;
        this.pathToPageAdmin = pathToPageAdmin;
        this.pathToPageModerator = pathToPageModerator;
    }

    SecurityService securityService = SecurityService.instance;

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
        UserRoleEnum role = securityService.getTokenInfo(request).getUserRole();
        switch (role) {
            case USER:
                this.sendRedirect(request, response, pathToPageUser);
                break;
            case ADMIN:
                this.sendRedirect(request, response, pathToPageAdmin);
                break;
            case MODERATOR:
                this.sendRedirect(request, response, pathToPageModerator);
                break;
        }
    }

    protected void sendRedirect(HttpServletRequest request, HttpServletResponse response, String pathToPage) {
        try {
            String path = request.getServletContext().getContextPath() + pathToPage;
            logger.info("SEND REDIRECT TO: " + pathToPage);
            response.sendRedirect(path);
        } catch (IOException ioException) {
            logger.warning(ioException.getMessage());
        }
    }
}

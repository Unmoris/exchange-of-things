package ru.rsreu.exchangethings.listner;

import ru.rsreu.exchangethings.security.SecurityService;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;

public class SessionListener implements HttpSessionListener {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final SecurityService securityService = SecurityService.getInstance();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        String token = session.getAttribute("token").toString();

        securityService.tokenRemove(token);

        logger.info("remove token");
    }
}

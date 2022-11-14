package com.example.exchangethings.listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.logging.Logger;

@WebListener
public class ListenerSession implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private Logger log =  Logger.getLogger("LISTENER");

    public ListenerSession() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        log.info("Session is created");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        log.info("Session is destroyed");

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}

package ru.rsreu.exchangethings.listner;

import ru.rsreu.exchangethings.model.service.UserService;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.security.token.TokenInfo;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;

public class SessionListener implements HttpSessionListener {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final SecurityService securityService = SecurityService.instance;

    private UserService userService = UserService.instance;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();

        String token = session.getAttribute("token").toString();
        TokenInfo info = securityService.getTokenInfo(token);

        userService.updateUserAuth(info.getUserId(), false);

        securityService.tokenRemove(token);


        logger.info("remove token");
    }
}

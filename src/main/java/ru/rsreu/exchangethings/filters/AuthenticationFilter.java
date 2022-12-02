package ru.rsreu.exchangethings.filters;

import ru.rsreu.exchangethings.view.parameters.ControlNames;
import ru.rsreu.exchangethings.exceptions.AuthenticationException;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.security.token.TokenStorage;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationFilter implements Filter {
    Logger logger = Logger.getLogger(this.getClass().getName());
    TokenStorage tokenService = SecurityService.instance;

    private Object getToken(HttpServletRequest request) {
        return request
                .getSession()
                .getAttribute("token");
    }

    private boolean isLoginCommand(ServletRequest request) {
        boolean isLoginCommand = false;
        String paramCommand = request.getParameter(ControlNames.CONTROL_COMMAND);

        if (paramCommand != null && paramCommand.equals("login"))
            isLoginCommand = true;

        return isLoginCommand;
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String token = (String) this.getToken(httpRequest);
        if ((token == null || !tokenService.tokenExist(token)) && (!this.isLoginCommand(request))) {
            logger.info("filter exception AuthenticationException");
            request.setAttribute("error", "Ошибка доступа");
            throw new AuthenticationException();
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

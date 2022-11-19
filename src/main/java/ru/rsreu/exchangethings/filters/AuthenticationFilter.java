package ru.rsreu.exchangethings.filters;

import ru.rsreu.exchangethings.exceptions.AuthenticationException;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.security.token.TokenExist;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class AuthenticationFilter implements Filter {
    Logger log = Logger.getLogger(this.getClass().getName());
    TokenExist tokenService = SecurityService.getInstance();

    private Object getToken(HttpServletRequest request) {
        return request
                .getSession()
                .getAttribute("token");
    }

    private boolean isLoginCommand(ServletRequest request) {
        boolean isLoginCommand = false;
        String paramCommand = request.getParameter("command");

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
            log.info("filter exception AuthenticationException");
            throw new AuthenticationException();
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

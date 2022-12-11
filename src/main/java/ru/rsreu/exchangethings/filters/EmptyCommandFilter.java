package ru.rsreu.exchangethings.filters;

import ru.rsreu.exchangethings.exceptions.AuthenticationException;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.security.token.TokenStorage;
import ru.rsreu.exchangethings.view.parameters.ControlNames;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EmptyCommandFilter implements Filter {

    TokenStorage tokenService = SecurityService.instance;

    private String getControlByRequestParameter(HttpServletRequest request, String nameParameter) {
        String control = "";
        String paramCommand = request.getParameter(nameParameter);
        if (paramCommand != null)
            control = paramCommand;
        return control;
    }

    protected String pathURI(HttpServletRequest httpRequest) {
        String path = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath() + '/';
        String newPath = path.replace(contextPath, "");
        String[] commandPath = newPath.split("/");
        return commandPath[0];
    }

    private Object getToken(HttpServletRequest request) {
        return request
                .getSession()
                .getAttribute("token");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String command = this.getControlByRequestParameter(httpRequest, ControlNames.CONTROL_COMMAND);
        if (command.isEmpty()) {
            if (pathURI(httpRequest)
                    .toUpperCase()
                    .equals(
                            tokenService
                                    .getTokenInfo(this.getToken(httpRequest).toString())
                                    .getUserRole()
                                    .name()
                    )
            ) {
                request.setAttribute(ControlNames.CONTROL_COMMAND, pathURI(httpRequest));
            } else {
                throw new AuthenticationException();
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

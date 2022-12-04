package ru.rsreu.exchangethings.filters;

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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String command = this.getControlByRequestParameter(httpRequest, ControlNames.CONTROL_COMMAND);
        if (command.isEmpty()) {
            request.setAttribute(ControlNames.CONTROL_COMMAND, pathURI(httpRequest));
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

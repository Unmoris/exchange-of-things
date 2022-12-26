package ru.rsreu.exchangethings.filters;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ContentTypeFilter implements Filter {
    private static final String ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {

        response.setCharacterEncoding(ENCODING);
        request.setCharacterEncoding(ENCODING);

        next.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
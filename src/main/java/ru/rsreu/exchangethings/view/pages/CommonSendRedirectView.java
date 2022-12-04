package ru.rsreu.exchangethings.view.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonSendRedirectView extends CommonView {

    protected CommonSendRedirectView(String initPathToJsp) {
        super(initPathToJsp);
    }

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
        this.sendRedirect(request, response);
    }
}

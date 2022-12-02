package ru.rsreu.exchangethings.view.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonForwardPage extends CommonView {

    public CommonForwardPage(String initPathToJsp) {
        super(initPathToJsp);
    }

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
        this.forwardToJsp(request, response);
    }
}

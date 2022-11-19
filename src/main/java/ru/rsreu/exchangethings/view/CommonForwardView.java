package ru.rsreu.exchangethings.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonForwardView extends CommonView {

    public CommonForwardView(String initPathToJsp) {
        super(initPathToJsp);
    }

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
        this.forwardToJsp(request, response);
    }
}

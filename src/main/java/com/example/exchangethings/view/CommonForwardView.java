package com.example.exchangethings.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class CommonForwardView extends CommonView {

    public CommonForwardView(String initPathToJsp) {
        super(initPathToJsp);
    }

    @Override
    public void show(HttpServletRequest request, HttpServletResponse response) {
        this.forwardToJsp(request, response);
    }
}

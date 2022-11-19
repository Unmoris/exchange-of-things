package ru.rsreu.exchangethings.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface View {
    public void show(HttpServletRequest request, HttpServletResponse response);
}

package ru.rsreu.exchangethings.view.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Page {
    public void show(HttpServletRequest request, HttpServletResponse response);
}

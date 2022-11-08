package com.example.exchangethings.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Helper {
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response);
}

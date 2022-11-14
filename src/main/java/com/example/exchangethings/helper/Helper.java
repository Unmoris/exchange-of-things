package com.example.exchangethings.helper;

import com.example.exchangethings.exceptions.IncludeParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Helper {
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException;

}

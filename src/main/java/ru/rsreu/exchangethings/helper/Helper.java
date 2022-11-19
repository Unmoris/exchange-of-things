package ru.rsreu.exchangethings.helper;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Helper {
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException;

}

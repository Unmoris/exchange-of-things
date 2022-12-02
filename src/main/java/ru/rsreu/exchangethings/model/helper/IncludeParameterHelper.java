package ru.rsreu.exchangethings.model.helper;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class IncludeParameterHelper implements Helper {
    abstract protected String getNameParameter();

    abstract protected Object getParameter();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute(this.getNameParameter(), this.getParameter());
    }
}

package com.example.exchangethings.helper;

import com.example.exchangethings.exceptions.IncludeParameterException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.logging.Logger;

public class LoggerHelper implements Helper {
    protected Logger logger = Logger.getLogger(this.getClass().getName());

    protected String logParams(Enumeration<String> atr) {
        StringBuilder str = new StringBuilder();
        while (atr.hasMoreElements()) {
            str.append(atr.nextElement());
        }
        return str.toString();
    }

    @Override
    public void includeParamsInScopes(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        logger.info("include parameters");
    }
}

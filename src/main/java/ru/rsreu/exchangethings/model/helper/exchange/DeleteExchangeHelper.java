package ru.rsreu.exchangethings.model.helper.exchange;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteExchangeHelper implements Helper {
    private RequestService requestService = RequestService.instance;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int id_exchange = Integer.parseInt(request.getParameter("id_exchange"));
        requestService.deleteRequest(id_exchange);
    }
}

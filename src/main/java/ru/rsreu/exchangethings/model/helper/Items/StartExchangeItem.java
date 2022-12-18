package ru.rsreu.exchangethings.model.helper.Items;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ExchangeStatusEnum;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartExchangeItem implements Helper {
    RequestService requestService = RequestService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        String comment = request.getParameter("comment");
        int recId = Integer.parseInt(request.getParameter("id_exchange"));
        int senderId = Integer.parseInt(request.getParameter("id_item"));
        requestService.createRequest(ExchangeStatusEnum.ACTIVE.order, comment, senderId, recId);
    }
}

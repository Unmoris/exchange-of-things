package ru.rsreu.exchangethings.model.helper.moderator;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ExchangeStatusEnum;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.RequestService;
import ru.rsreu.exchangethings.view.beans.RequestBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllExchangesHelper extends MenuHelper {
    RequestService requestService = RequestService.instance;

    public AllExchangesHelper() {
        super("exchanges");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        List<RequestBean> requestBeanList = requestService.getRequestByStatus(ExchangeStatusEnum.ACTIVE);

        request.setAttribute("exchanges", requestBeanList);
        super.execute(request, response);
    }
}

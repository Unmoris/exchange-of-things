package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ExchangeStatusEnum;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.RequestService;
import ru.rsreu.exchangethings.security.SecurityService;
import ru.rsreu.exchangethings.view.beans.RequestBean;
import ru.rsreu.exchangethings.view.beans.ItemBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Arrays;

public class UserExchangesHelper extends MenuHelper {
    private RequestService requestService = RequestService.instance;

    public UserExchangesHelper() {
        super("exchange");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int userId = securityService.getTokenInfo(request).getUserId();
        request.setAttribute("exchanges", requestService.getRequestByUserIdAndStatus(userId, ExchangeStatusEnum.ACTIVE));
        super.execute(request, response);
    }
}

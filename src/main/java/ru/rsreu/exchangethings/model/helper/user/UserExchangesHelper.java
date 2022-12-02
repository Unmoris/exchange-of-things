package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.view.beans.ExchangeBean;
import ru.rsreu.exchangethings.view.beans.ItemBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Arrays;

public class UserExchangesHelper extends MenuHelper {
    public UserExchangesHelper() {
        super("exchange");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("exchanges", Arrays.asList(new ExchangeBean(1, LocalDate.now().toString(), "1", "1", new ItemBean(), new ItemBean()), new ExchangeBean(1, LocalDate.now().toString(), "1", "1", new ItemBean(), new ItemBean())));
        super.execute(request, response);
    }
}

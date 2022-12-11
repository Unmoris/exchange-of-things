package ru.rsreu.exchangethings.model.helper.moderator;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.mock.GetMockData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllItemsHelper extends MenuHelper {
    public AllItemsHelper() {
        super("items");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("items", GetMockData.getItemBean());
        super.execute(request, response);
    }
}

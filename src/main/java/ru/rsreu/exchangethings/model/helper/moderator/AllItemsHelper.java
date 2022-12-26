package ru.rsreu.exchangethings.model.helper.moderator;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllItemsHelper extends MenuHelper {
    public AllItemsHelper() {
        super("items");
    }
    ItemService itemService =  ItemService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        request.setAttribute("items", itemService.getAllItems());
        super.execute(request, response);
    }
}

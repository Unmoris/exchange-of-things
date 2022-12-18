package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ItemStatusEnum;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class ItemsListForUserHelper extends MenuHelper {

    private ItemService itemService = ItemService.instance;

    public ItemsListForUserHelper() {
        super("list_items");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int userId = securityService.getTokenInfo(request).getUserId();
        request.setAttribute("items", itemService.getItemForUser(userId, ItemStatusEnum.OPEN));
        super.execute(request, response);
    }
}

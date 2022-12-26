package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ItemStatusEnum;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.view.beans.ItemBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserItemsHelper extends MenuHelper {
    private ItemService itemService = ItemService.instance;

    public UserItemsHelper() {
        super("my_items");
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int userId = securityService.getTokenInfo(request).getUserId();
        List<ItemBean> items = itemService.getUserItems(userId, ItemStatusEnum.OPEN.order);
        items.addAll(itemService.getUserItems(userId, ItemStatusEnum.HIDDEN.order));
        request.setAttribute("items", items);
        super.execute(request, response);
    }
}

package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.model.service.RequestService;
import ru.rsreu.exchangethings.model.service.UserService;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.RequestBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;

public class DeleteUserHelper implements Helper {
    UserService userService = UserService.instance;
    private ItemService itemService = ItemService.instance;
    private RequestService requestService = RequestService.instance;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int userId = 1;

        List<ItemBean> items = itemService.getUserItems(userId);
        List<List<RequestBean>> requestsLists = new LinkedList<>();
        for (ItemBean item: items) {
            for (RequestBean ls: requestService.getRequestByItem(item.getId(),item.getId())) {
                requestService.deleteRequest(ls.getId());
            }
            itemService.deleteItem(item.getId());
        }
        userService.deleteUser(userId);
    }
}

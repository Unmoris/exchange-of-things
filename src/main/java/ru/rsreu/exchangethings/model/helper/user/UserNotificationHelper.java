package ru.rsreu.exchangethings.model.helper.user;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ItemStatusEnum;
import ru.rsreu.exchangethings.model.helper.MenuHelper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.model.service.RequestService;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.NotificationBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserNotificationHelper extends MenuHelper {
    private ItemService itemService = ItemService.instance;
    private RequestService requestService = RequestService.instance;

    public UserNotificationHelper(String menuParameter) {
        super(menuParameter);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int userId = securityService.getTokenInfo(request).getUserId();
        List<ItemBean> itemBeans = itemService.getUserItems(userId, ItemStatusEnum.BLOCKED.order);
        List<NotificationBean> notificationBeans = itemBeans
                .stream()
                .map(itemBean -> new NotificationBean("Модератором был заблокирован предмет " + itemBean.getTitle()))
                .collect(Collectors.toList());
        request.setAttribute("notifications", notificationBeans);
        super.execute(request, response);
    }
}

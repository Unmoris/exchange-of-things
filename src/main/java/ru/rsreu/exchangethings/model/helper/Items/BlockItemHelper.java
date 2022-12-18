package ru.rsreu.exchangethings.model.helper.Items;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ExchangeStatusEnum;
import ru.rsreu.exchangethings.model.ItemStatusEnum;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.model.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlockItemHelper implements Helper {
    private ItemService itemService = ItemService.instance;
    private RequestService requestService = RequestService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int idItem = Integer.parseInt(request.getParameter("id_item"));
        requestService.updateStatusByItem(idItem, ExchangeStatusEnum.CANCEL);
        itemService.updateStatus(idItem, ItemStatusEnum.BLOCKED);
    }
}

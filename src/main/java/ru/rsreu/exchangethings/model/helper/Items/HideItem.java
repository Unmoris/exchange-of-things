package ru.rsreu.exchangethings.model.helper.Items;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ItemStatusEnum;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HideItem implements Helper {
ItemService itemService = ItemService.instance;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int idItem = Integer.parseInt(request.getParameter("id_item"));
        itemService.updateStatus(idItem, ItemStatusEnum.HIDDEN);
    }
}

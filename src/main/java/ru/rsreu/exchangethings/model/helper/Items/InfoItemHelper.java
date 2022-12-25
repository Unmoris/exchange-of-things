package ru.rsreu.exchangethings.model.helper.Items;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.view.beans.ItemBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoItemHelper implements Helper {

    ItemService itemService = ItemService.instance;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IncludeParameterException {
        int idItem = Integer.parseInt(request.getParameter("id_item"));
        ItemBean itemBean = itemService.getItemByIdWithOwner(idItem);
        itemService.incrementCountView(idItem);
        request.setAttribute("item", itemBean);
    }
}

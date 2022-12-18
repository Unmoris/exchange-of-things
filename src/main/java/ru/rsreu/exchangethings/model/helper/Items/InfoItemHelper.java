package ru.rsreu.exchangethings.model.helper.Items;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.helper.Helper;
import ru.rsreu.exchangethings.model.service.ItemService;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;

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
